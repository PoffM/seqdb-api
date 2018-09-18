Build and launch
================

Required
--------

* Java 1.8+
* Maven 3.2+

To launch
---------

.. code-block:: bash
  mvn clean spring-boot:run

To run tests
------------

Unit tests:
.. code-block:: bash
  mvn clean test

All tests (Integration + Unit):
.. code-block:: bash
  mvn clean verify

To package
----------

.. code-block:: bash
  mvn clean install

This will create an executable jar.

To run the packaged application (using an embedded Tomcat instance)
-------------------------------------------------------------------

.. code-block:: bash
  java -jar seqdb.api.jar

You can also include configuration from an external file:

.. code-block:: bash
  java -jar seqdb.api.jar --spring.config.additional-location=./myconfig.yml
