package com.tmousa.availablehotels.utils.converter;

/**
 * The TypeConverter Interface
 * A Service for Converting between object types
 *
 * @author  tmousa
 */
public interface TypeConverter<T extends Object, U extends Object> {

    /**
     * convert
     * This method Converts between object types
     *
     * @param object object to be converted
     *
     * @return converted object
     */
    T convert(U object);
}
