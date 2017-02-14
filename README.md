# prepared statement debugging w/slick and doobie through pgbouncer

1. configure pgbouncer.ini and src/main/resources.application.conf so that database names/users/ports match up with whatever you have (probably replace `hoopla` with `YOUR_DATABASE_NAME` and `YOUR_DATABASE_USER`)
1. Run `$ sbt run` a few times, verify that it works.
2. launch pgbouncer `$ pgbouncer pgbouncer.ini`
3. Run w/pgbouncer `$ PSQL_PORT=6432 sbt run`, verify that it does not work.
