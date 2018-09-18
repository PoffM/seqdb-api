Database migration with Liquibase
=================================

This application uses Liquibase to generate the database and migrate to new versions of the database. Changelogs are source xml files that describe schema changes to the database. Liquibase maintains a "DATABASECHANGELOG" table in the same database to keep track of which changelogs have been executed. When the application starts, any changelogs that have not been executed are executed.

Our changelogs are kept in src/main/resources/db/changelog.

When adding a new migration changelog, put the new file in src/main/resources/db/changelog/migrations, and name the file after the issue, e.g. db.changelog-Feature\_15\_Add\_Sample\_Table.xml". Then add the new file's path to src/main/resources/db/changelog/db.changelog-master.xml in an "include" tag.

 * `Liquibase home <https://www.liquibase.org/index.html>`_
 * `Liquibase Best Practice <https://www.liquibase.org/bestpractices.html>`_
 * `Change example: addColumn <https://www.liquibase.org/documentation/changes/add_column.html>`_
 * `Adding Liquibase support to an existing database <https://www.liquibase.org/documentation/generating_changelogs.html>`_