/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011, Red Hat, Inc. and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.jdiameter.common.impl.concurrent;

import org.jdiameter.common.api.statistic.IStatistic;
import org.jdiameter.common.api.statistic.IStatisticRecord;

abstract class AbstractTask<L> {

  protected L parentTask;
  protected long createdTime = System.nanoTime();

  protected IStatistic statistic;

  protected IStatisticRecord execTimeSumm;
  protected IStatisticRecord execTimeCount;

  protected IStatisticRecord waitTimeSumm;
  protected IStatisticRecord waitTimeCount;

  public AbstractTask(L task, final IStatistic statistic, IStatisticRecord... statisticRecords) {
    this.parentTask = task;
    execTimeSumm = statisticRecords[0];
    execTimeCount = statisticRecords[1];
    waitTimeSumm = statisticRecords[2];
    waitTimeCount = statisticRecords[3];
    this.statistic = statistic;
  }

  protected IStatisticRecord getCounter(IStatistic.Counters counter) {
    return statistic.getRecordByName(counter.name());
  }

  protected void updateTimeStatistic(long time, long waitTime) {
    execTimeSumm.inc((System.nanoTime() - time) / 999999);
    execTimeCount.inc();
    waitTimeSumm.inc(waitTime / 999999);
    waitTimeCount.inc();
  }

  @Override
  public boolean equals(Object o) {
    return this == o || parentTask.equals(o);
  }

  @Override
  public int hashCode() {
    return parentTask.hashCode();
  }

  public static class AverajeValueHolder implements IStatisticRecord.ValueHolder {
    private IStatistic statistic;
    private IStatistic.Counters counter;

    public AverajeValueHolder(IStatistic statistic, IStatistic.Counters counter) {
      this.statistic = statistic;
      this.counter = counter;
    }

    public double getValueAsDouble() {
      IStatisticRecord record = statistic.getRecordByName(counter.name());
      if (record.getChilds().length == 2 || record.getChilds()[1].getValueAsLong() != 0) {
        long count = record.getChilds()[1].getValueAsLong();
        return ((float) record.getChilds()[0].getValueAsLong()) / ((float) (count != 0 ? count : 1));
      }
      else {
        return 0;
      }
    }

    public String getValueAsString() {
      return String.valueOf(getValueAsDouble());
    }
  }
}
