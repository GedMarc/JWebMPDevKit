/*
 * Copyright (c) 2011, 2019 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0,
 * or the Eclipse Distribution License v. 1.0 which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: EPL-2.0 OR BSD-3-Clause
 */

// Contributors:
//     Petros Splinakis - 2.2
//     Linda DeMichiel - 2.1


package javax.persistence;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;  

/**
 * Specifies and names a stored procedure, its parameters, and its result type.
 *
 * <p>The <code>NamedStoredProcedureQuery</code> annotation can be applied to an 
 * entity or mapped superclass.
 *
 * <p>The <code>name</code> element is the name that is passed as an argument to the
 * {@link EntityManager#createNamedStoredProcedureQuery}
 * method to create an executable <code>StoredProcedureQuery</code> object.
 * Names are scoped to the persistence unit.
 *
 * <p>The <code>procedureName</code> element is the name of the stored procedure in
 * the database.
 *
 * <p>The parameters of the stored procedure are specified by the
 * <code>parameters</code> element. All parameters must be specified in the order in
 * which they occur in the parameter list of the stored procedure.
 *
 * <p>The <code>resultClasses</code> element refers to the class (or classes) that are
 * used to map the results. The <code>resultSetMappings</code> element names one or
 * more result set mappings, as defined by the {@link SqlResultSetMapping}
 * annotation.
 *
 * <p>If there are multiple result sets, it is assumed that they will be
 * mapped using the same mechanism &#8212; e.g., either all via a set of
 * result class mappings or all via a set of result set mappings. The
 * order of the specification of these mappings must be the same as
 * the order in which the result sets will be returned by the stored
 * procedure invocation. If the stored procedure returns one or more
 * result sets and no <code>resultClasses</code> or <code>resultSetMappings</code>
 * element is specified, any result set will be returned as a list of type
 * Object[]. The combining of different strategies for the mapping of
 * stored procedure result sets is undefined.
 *
 * <p>The <code>hints</code> element may be used to specify query properties and
 * hints. Properties defined by this specification must be observed by
 * the provider. Vendor-specific hints that are not recognized by a
 * provider must be ignored.
 *
 * <p>All parameters of a named stored procedure query must be specified
 * using the <code>StoredProcedureParameter</code> annotation.
 *
 * @see StoredProcedureQuery
 * @see StoredProcedureParameter
 *
 * @since 2.1
 */
@Repeatable(NamedStoredProcedureQueries.class)
@Target({TYPE}) 
@Retention(RUNTIME)
public @interface NamedStoredProcedureQuery { 

    /**
     * The name used to refer to the query with the {@link EntityManager} 
     * methods that create stored procedure query objects.
     */
    String name();

    /** The name of the stored procedure in the database. */
    String procedureName();

    /**
     *  Information about all parameters of the stored procedure.
     *  All parameters must be specified in the order in which they
     *  occur in the parameter list of the stored procedure.
     */
    StoredProcedureParameter[] parameters() default {};

    /** The class or classes that are used to map the results. */
    Class[] resultClasses() default {}; 

    /** The names of one or more result set mappings, as defined in metadata. */
    String[] resultSetMappings() default {};

    /** Query properties and hints.  (May include vendor-specific query hints.) */
    QueryHint[] hints() default {};

}
