/*
 * Copyright (c) 1997, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

package com.sun.el.lang;

import static java.math.BigDecimal.ROUND_HALF_UP;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.sun.el.util.MessageFactory;

/**
 * A helper class of Arithmetic defined by the Jakarta Expression Specification
 *
 * @author Jacob Hookom [jacob@hookom.net]
 * @version $Change: 181177 $$DateTime: 2001/06/26 08:45:09 $$Author: kchung $
 */
public abstract class ELArithmetic {

    public final static class BigDecimalDelegate extends ELArithmetic {

        @Override
        protected Number add(Number num0, Number num1) {
            return ((BigDecimal) num0).add((BigDecimal) num1);
        }

        @Override
        protected Number coerce(Number num) {
            if (num instanceof BigDecimal) {
                return num;
            }
            if (num instanceof BigInteger) {
                return new BigDecimal((BigInteger) num);
            }

            return new BigDecimal(num.doubleValue());
        }

        @Override
        protected Number coerce(String str) {
            return new BigDecimal(str);
        }

        @Override
        protected Number divide(Number num0, Number num1) {
            return ((BigDecimal) num0).divide((BigDecimal) num1, ROUND_HALF_UP);
        }

        @Override
        protected Number subtract(Number num0, Number num1) {
            return ((BigDecimal) num0).subtract((BigDecimal) num1);
        }

        @Override
        protected Number mod(Number num0, Number num1) {
            return Double.valueOf(num0.doubleValue() % num1.doubleValue());
        }

        @Override
        protected Number multiply(Number num0, Number num1) {
            return ((BigDecimal) num0).multiply((BigDecimal) num1);
        }

        @Override
        public boolean matches(Object obj0, Object obj1) {
            return (obj0 instanceof BigDecimal || obj1 instanceof BigDecimal);
        }
    }

    public final static class BigIntegerDelegate extends ELArithmetic {

        @Override
        protected Number add(Number num0, Number num1) {
            return ((BigInteger) num0).add((BigInteger) num1);
        }

        @Override
        protected Number coerce(Number num) {
            if (num instanceof BigInteger) {
                return num;
            }

            return new BigInteger(num.toString());
        }

        @Override
        protected Number coerce(String str) {
            return new BigInteger(str);
        }

        @Override
        protected Number divide(Number num0, Number num1) {
            return (new BigDecimal((BigInteger) num0)).divide(new BigDecimal((BigInteger) num1), ROUND_HALF_UP);
        }

        @Override
        protected Number multiply(Number num0, Number num1) {
            return ((BigInteger) num0).multiply((BigInteger) num1);
        }

        @Override
        protected Number mod(Number num0, Number num1) {
            return ((BigInteger) num0).mod((BigInteger) num1);
        }

        @Override
        protected Number subtract(Number num0, Number num1) {
            return ((BigInteger) num0).subtract((BigInteger) num1);
        }

        @Override
        public boolean matches(Object obj0, Object obj1) {
            return obj0 instanceof BigInteger || obj1 instanceof BigInteger;
        }
    }

    public final static class DoubleDelegate extends ELArithmetic {

        @Override
        protected Number add(Number num0, Number num1) {
            // could only be one of these
            if (num0 instanceof BigDecimal) {
                return ((BigDecimal) num0).add(new BigDecimal(num1.doubleValue()));
            }
            if (num1 instanceof BigDecimal) {
                return ((new BigDecimal(num0.doubleValue()).add((BigDecimal) num1)));
            }

            return Double.valueOf(num0.doubleValue() + num1.doubleValue());
        }

        @Override
        protected Number coerce(Number num) {
            if (num instanceof Double) {
                return num;
            }
            if (num instanceof BigInteger) {
                return new BigDecimal((BigInteger) num);
            }

            return Double.valueOf(num.doubleValue());
        }

        @Override
        protected Number coerce(String str) {
            return Double.valueOf(str);
        }

        @Override
        protected Number divide(Number num0, Number num1) {
            return Double.valueOf(num0.doubleValue() / num1.doubleValue());
        }

        @Override
        protected Number mod(Number num0, Number num1) {
            return Double.valueOf(num0.doubleValue() % num1.doubleValue());
        }

        @Override
        protected Number subtract(Number num0, Number num1) {
            // could only be one of these
            if (num0 instanceof BigDecimal) {
                return ((BigDecimal) num0).subtract(new BigDecimal(num1.doubleValue()));
            }

            if (num1 instanceof BigDecimal) {
                return ((new BigDecimal(num0.doubleValue()).subtract((BigDecimal) num1)));
            }

            return Double.valueOf(num0.doubleValue() - num1.doubleValue());
        }

        @Override
        protected Number multiply(Number num0, Number num1) {
            // could only be one of these
            if (num0 instanceof BigDecimal) {
                return ((BigDecimal) num0).multiply(new BigDecimal(num1.doubleValue()));
            }
            if (num1 instanceof BigDecimal) {
                return ((new BigDecimal(num0.doubleValue()).multiply((BigDecimal) num1)));
            }

            return Double.valueOf(num0.doubleValue() * num1.doubleValue());
        }

        @Override
        public boolean matches(Object obj0, Object obj1) {
            return (obj0 instanceof Double || obj1 instanceof Double || obj0 instanceof Float || obj1 instanceof Float
                    || (obj0 != null && (Double.TYPE == obj0.getClass() || Float.TYPE == obj0.getClass()))
                    || (obj1 != null && (Double.TYPE == obj1.getClass() || Float.TYPE == obj1.getClass()))
                    || (obj0 instanceof String && ELSupport.isStringFloat((String) obj0))
                    || (obj1 instanceof String && ELSupport.isStringFloat((String) obj1)));
        }
    }

    public final static class LongDelegate extends ELArithmetic {

        @Override
        protected Number add(Number num0, Number num1) {
            return Long.valueOf(num0.longValue() + num1.longValue());
        }

        @Override
        protected Number coerce(Number num) {
            if (num instanceof Long) {
                return num;
            }

            return Long.valueOf(num.longValue());
        }

        @Override
        protected Number coerce(String str) {
            return Long.valueOf(str);
        }

        @Override
        protected Number divide(Number num0, Number num1) {
            return Long.valueOf(num0.longValue() / num1.longValue());
        }

        @Override
        protected Number mod(Number num0, Number num1) {
            return Long.valueOf(num0.longValue() % num1.longValue());
        }

        @Override
        protected Number subtract(Number num0, Number num1) {
            return Long.valueOf(num0.longValue() - num1.longValue());
        }

        @Override
        protected Number multiply(Number num0, Number num1) {
            return Long.valueOf(num0.longValue() * num1.longValue());
        }

        @Override
        public boolean matches(Object obj0, Object obj1) {
            return obj0 instanceof Long || obj1 instanceof Long;
        }
    }

    public static final BigDecimalDelegate BIGDECIMAL = new BigDecimalDelegate();
    public static final BigIntegerDelegate BIGINTEGER = new BigIntegerDelegate();
    public static final DoubleDelegate DOUBLE = new DoubleDelegate();
    public static final LongDelegate LONG = new LongDelegate();
    private static final Long ZERO = Long.valueOf(0);

    public final static Number add(final Object obj0, final Object obj1) {
        if (obj0 == null && obj1 == null) {
            return Long.valueOf(0);
        }

        final ELArithmetic delegate;
        if (BIGDECIMAL.matches(obj0, obj1)) {
            delegate = BIGDECIMAL;
        } else if (DOUBLE.matches(obj0, obj1)) {
            delegate = DOUBLE;
        } else if (BIGINTEGER.matches(obj0, obj1)) {
            delegate = BIGINTEGER;
        } else {
            delegate = LONG;
        }

        Number num0 = delegate.coerce(obj0);
        Number num1 = delegate.coerce(obj1);

        return delegate.add(num0, num1);
    }

    public final static Number mod(final Object obj0, final Object obj1) {
        if (obj0 == null && obj1 == null) {
            return Long.valueOf(0);
        }

        final ELArithmetic delegate;
        if (BIGDECIMAL.matches(obj0, obj1)) {
            delegate = BIGDECIMAL;
        } else if (DOUBLE.matches(obj0, obj1)) {
            delegate = DOUBLE;
        } else if (BIGINTEGER.matches(obj0, obj1)) {
            delegate = BIGINTEGER;
        } else {
            delegate = LONG;
        }

        Number num0 = delegate.coerce(obj0);
        Number num1 = delegate.coerce(obj1);

        return delegate.mod(num0, num1);
    }

    public final static Number subtract(final Object obj0, final Object obj1) {
        if (obj0 == null && obj1 == null) {
            return Long.valueOf(0);
        }

        final ELArithmetic delegate;
        if (BIGDECIMAL.matches(obj0, obj1)) {
            delegate = BIGDECIMAL;
        } else if (DOUBLE.matches(obj0, obj1)) {
            delegate = DOUBLE;
        } else if (BIGINTEGER.matches(obj0, obj1)) {
            delegate = BIGINTEGER;
        } else {
            delegate = LONG;
        }

        Number num0 = delegate.coerce(obj0);
        Number num1 = delegate.coerce(obj1);

        return delegate.subtract(num0, num1);
    }

    public final static Number divide(final Object obj0, final Object obj1) {
        if (obj0 == null && obj1 == null) {
            return ZERO;
        }

        final ELArithmetic delegate;
        if (BIGDECIMAL.matches(obj0, obj1)) {
            delegate = BIGDECIMAL;
        } else if (BIGINTEGER.matches(obj0, obj1)) {
            delegate = BIGDECIMAL;
        } else {
            delegate = DOUBLE;
        }

        Number num0 = delegate.coerce(obj0);
        Number num1 = delegate.coerce(obj1);

        return delegate.divide(num0, num1);
    }

    public final static Number multiply(final Object obj0, final Object obj1) {
        if (obj0 == null && obj1 == null) {
            return Long.valueOf(0);
        }

        final ELArithmetic delegate;
        if (BIGDECIMAL.matches(obj0, obj1)) {
            delegate = BIGDECIMAL;
        } else if (DOUBLE.matches(obj0, obj1)) {
            delegate = DOUBLE;
        } else if (BIGINTEGER.matches(obj0, obj1)) {
            delegate = BIGINTEGER;
        } else {
            delegate = LONG;
        }

        Number num0 = delegate.coerce(obj0);
        Number num1 = delegate.coerce(obj1);

        return delegate.multiply(num0, num1);
    }

    public final static boolean isNumber(final Object obj) {
        return (obj != null && isNumberType(obj.getClass()));
    }

    public final static boolean isNumberType(final Class type) {
        return type == Long.TYPE || type == Double.TYPE || type == Byte.TYPE || type == Short.TYPE || type == Integer.TYPE || type == Float.TYPE
                || Number.class.isAssignableFrom(type);
    }

    /**
     *
     */
    protected ELArithmetic() {
        super();
    }

    protected abstract Number add(final Number num0, final Number num1);

    protected abstract Number multiply(final Number num0, final Number num1);

    protected abstract Number subtract(final Number num0, final Number num1);

    protected abstract Number mod(final Number num0, final Number num1);

    protected abstract Number coerce(final Number num);

    protected final Number coerce(final Object obj) {

        if (isNumber(obj)) {
            return coerce((Number) obj);
        }
        if (obj instanceof String) {
            return coerce((String) obj);
        }
        if (obj == null || "".equals(obj)) {
            return coerce(ZERO);
        }

        Class objType = obj.getClass();
        if (Character.class.equals(objType) || Character.TYPE == objType) {
            return coerce(Short.valueOf((short) ((Character) obj).charValue()));
        }

        throw new IllegalArgumentException(MessageFactory.get("el.convert", obj, objType));
    }

    protected abstract Number coerce(final String str);

    protected abstract Number divide(final Number num0, final Number num1);

    protected abstract boolean matches(final Object obj0, final Object obj1);

}
