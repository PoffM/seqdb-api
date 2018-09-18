Build and launch
================

Required
--------

* Java 1.8+
* Maven 3.2+

Launch
------

.. code-block:: console

  mvn clean spring-boot:run

Run unit tests
--------------

.. code-block:: console

  mvn clean test

Run All tests (Integration + Unit)
----------------------------------

.. code-block:: console

  mvn clean verify

Package
-------

.. code-block:: console

  mvn clean install

This will create an executable jar.

Run the packaged application
----------------------------

.. code-block:: console

  java -jar seqdb.api.jar

You can also include configuration from an external file:

.. code-block:: console

  java -jar seqdb.api.jar --spring.config.additional-location=./myconfig.yml
