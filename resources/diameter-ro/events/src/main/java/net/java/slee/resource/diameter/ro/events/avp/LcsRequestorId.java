package net.java.slee.resource.diameter.ro.events.avp;

import net.java.slee.resource.diameter.base.events.avp.GroupedAvp;

/**
 * Defines an interface representing the LCS-Requestor-ID grouped AVP type.<br>
 * <br>
 * From the Diameter Ro Reference Point Protocol Details (3GPP TS 32.299 V7.1.0) specification:
 * <pre>
 * 7.2.50 LCS-Requestor-ID AVP
 * The LCS-Requestor-ID AVP (AVP code 1239) is of type Grouped and contains information related to the identification
 * of the Requestor. 
 * 
 * It has the following ABNF grammar: 
 *  LCS-Requestor-ID ::= AVP Header: 1239 
 *      [ LCS-Data-Coding-Scheme ] 
 *      [ LCS-Requestor-ID-String ]
 * </pre>
 * 
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 */
public interface LcsRequestorId extends GroupedAvp {

  /**
   * Returns the value of the LCS-Data-Coding-Scheme AVP, of type UTF8String. A return value of null implies that the AVP has not been set.
   */
  abstract String getLcsDataCodingScheme();

  /**
   * Returns the value of the LCS-Requestor-ID-String AVP, of type UTF8String. A return value of null implies that the AVP has not been set.
   */
  abstract String getLcsRequestorIdString();

  /**
   * Returns true if the LCS-Data-Coding-Scheme AVP is present in the message.
   */
  abstract boolean hasLcsDataCodingScheme();

  /**
   * Returns true if the LCS-Requestor-ID-String AVP is present in the message.
   */
  abstract boolean hasLcsRequestorIdString();

  /**
   * Sets the value of the LCS-Data-Coding-Scheme AVP, of type UTF8String.
   */
  abstract void setLcsDataCodingScheme(String lcsDataCodingScheme);

  /**
   * Sets the value of the LCS-Requestor-ID-String AVP, of type UTF8String.
   */
  abstract void setLcsRequestorIdString(String lcsRequestorIdString);

}
