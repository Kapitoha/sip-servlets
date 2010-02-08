package org.mobicents.slee.resource.diameter.ro.events.avp;

import net.java.slee.resource.diameter.ro.events.avp.MediaInitiatorFlag;
import net.java.slee.resource.diameter.ro.events.avp.SdpMediaComponent;

import org.mobicents.slee.resource.diameter.base.events.avp.GroupedAvpImpl;

/**
 * 
 * SdpMediaComponentImpl.java
 *
 * <br>Project:  mobicents
 * <br>11:19:56 PM Apr 11, 2009 
 * <br>
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 */
public class SdpMediaComponentImpl extends GroupedAvpImpl implements SdpMediaComponent {

  /**
   * @param code
   * @param vendorId
   * @param mnd
   * @param prt
   * @param value
   */
  public SdpMediaComponentImpl( int code, long vendorId, int mnd, int prt, byte[] value ) {
    super( code, vendorId, mnd, prt, value );
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.ro.events.avp.SdpMediaComponent#getAuthorizedQos()
   */
  public String getAuthorizedQos() {
    return getAvpAsUTF8String(DiameterRoAvpCodes.AUTHORIZED_QOS, DiameterRoAvpCodes.TGPP_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.ro.events.avp.SdpMediaComponent#getMediaInitiatorFlag()
   */
  public MediaInitiatorFlag getMediaInitiatorFlag() {
    return (MediaInitiatorFlag) getAvpAsEnumerated(DiameterRoAvpCodes.MEDIA_INITIATOR_FLAG, DiameterRoAvpCodes.TGPP_VENDOR_ID, MediaInitiatorFlag.class);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.ro.events.avp.SdpMediaComponent#getSdpMediaDescriptions()
   */
  public String[] getSdpMediaDescriptions() {
    return getAvpsAsUTF8String(DiameterRoAvpCodes.SDP_MEDIA_DESCRIPTION, DiameterRoAvpCodes.TGPP_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.ro.events.avp.SdpMediaComponent#getSdpMediaName()
   */
  public String getSdpMediaName() {
    return getAvpAsUTF8String(DiameterRoAvpCodes.SDP_MEDIA_NAME, DiameterRoAvpCodes.TGPP_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.ro.events.avp.SdpMediaComponent#getTgppChargingId()
   */
  public String getTgppChargingId() {
    return getAvpAsOctetString(DiameterRoAvpCodes.TGPP_CHARGING_ID, DiameterRoAvpCodes.TGPP_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.ro.events.avp.SdpMediaComponent#hasAuthorizedQos()
   */
  public boolean hasAuthorizedQos() {
    return hasAvp(DiameterRoAvpCodes.AUTHORIZED_QOS, DiameterRoAvpCodes.TGPP_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.ro.events.avp.SdpMediaComponent#hasMediaInitiatorFlag()
   */
  public boolean hasMediaInitiatorFlag() {
    return hasAvp(DiameterRoAvpCodes.MEDIA_INITIATOR_FLAG, DiameterRoAvpCodes.TGPP_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.ro.events.avp.SdpMediaComponent#hasSdpMediaName()
   */
  public boolean hasSdpMediaName() {
    return hasAvp(DiameterRoAvpCodes.SDP_MEDIA_NAME, DiameterRoAvpCodes.TGPP_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.ro.events.avp.SdpMediaComponent#hasTgppChargingId()
   */
  public boolean hasTgppChargingId() {
    return hasAvp(DiameterRoAvpCodes.TGPP_CHARGING_ID, DiameterRoAvpCodes.TGPP_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.ro.events.avp.SdpMediaComponent#setAuthorizedQos(String)
   */
  public void setAuthorizedQos( String authorizedQos ) {
    addAvp(DiameterRoAvpCodes.AUTHORIZED_QOS, DiameterRoAvpCodes.TGPP_VENDOR_ID, authorizedQos);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.ro.events.avp.SdpMediaComponent#setMediaInitiatorFlag(net.java.slee.resource.diameter.ro.events.avp.MediaInitiatorFlag)
   */
  public void setMediaInitiatorFlag( MediaInitiatorFlag mediaInitiatorFlag ) {
    addAvp(DiameterRoAvpCodes.MEDIA_INITIATOR_FLAG, DiameterRoAvpCodes.TGPP_VENDOR_ID, mediaInitiatorFlag.getValue());
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.ro.events.avp.SdpMediaComponent#setSdpMediaDescription(String)
   */
  public void setSdpMediaDescription( String sdpMediaDescription ) {
    addAvp(DiameterRoAvpCodes.SDP_MEDIA_DESCRIPTION, DiameterRoAvpCodes.TGPP_VENDOR_ID, sdpMediaDescription);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.ro.events.avp.SdpMediaComponent#setSdpMediaDescriptions(String[])
   */
  public void setSdpMediaDescriptions( String[] sdpMediaDescriptions ) {
    for(String sdpMediaDescription : sdpMediaDescriptions) {
      setSdpMediaDescription(sdpMediaDescription);
    }
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.ro.events.avp.SdpMediaComponent#setSdpMediaName(String)
   */
  public void setSdpMediaName( String sdpMediaName ) {
    addAvp(DiameterRoAvpCodes.SDP_MEDIA_NAME, DiameterRoAvpCodes.TGPP_VENDOR_ID, sdpMediaName);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.ro.events.avp.SdpMediaComponent#setTgppChargingId(byte[])
   */
  public void setTgppChargingId( String tgppChargingId ) {
    addAvp(DiameterRoAvpCodes.TGPP_CHARGING_ID, DiameterRoAvpCodes.TGPP_VENDOR_ID, tgppChargingId);
  }

}
