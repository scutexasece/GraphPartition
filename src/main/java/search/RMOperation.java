/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package search;


public enum RMOperation implements org.apache.thrift.TEnum {
  NOTIFICATION(0),
  CONFIRM(1);

  private final int value;

  private RMOperation(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  public static RMOperation findByValue(int value) { 
    switch (value) {
      case 0:
        return NOTIFICATION;
      case 1:
        return CONFIRM;
      default:
        return null;
    }
  }
}