# Java Microservices with Spring Cloud: Developing Services

While Running the Program, please pass below in the program parameters.

```
Spring42
SPRINGRX
2020-01-01
```

Query to MySQL

```
mysql> use tasklogs;
Database changed
mysql> show tables;
+-----------------------+
| Tables_in_tasklogs    |
+-----------------------+
| task_execution        |
| task_execution_params |
| task_lock             |
| task_seq              |
| task_task_batch       |
+-----------------------+
5 rows in set (0.00 sec)

mysql> select * from task_execution;
+-------------------+---------------------+---------------------+----------------+-----------+--------------+---------------+---------------------+-----------------------+---------------------+
| TASK_EXECUTION_ID | START_TIME          | END_TIME            | TASK_NAME      | EXIT_CODE | EXIT_MESSAGE | ERROR_MESSAGE | LAST_UPDATED        | EXTERNAL_EXECUTION_ID | PARENT_EXECUTION_ID |
+-------------------+---------------------+---------------------+----------------+-----------+--------------+---------------+---------------------+-----------------------+---------------------+
|                 1 | 2020-01-05 02:13:51 | 2020-01-05 02:13:51 | Toll Processor |         0 | NULL         | NULL          | 2020-01-05 02:13:51 | NULL                  |                NULL |
+-------------------+---------------------+---------------------+----------------+-----------+--------------+---------------+---------------------+-----------------------+---------------------+
1 row in set (0.00 sec)

mysql> select * from task_execution_params;
+-------------------+-------------------------------------+
| TASK_EXECUTION_ID | TASK_PARAM                          |
+-------------------+-------------------------------------+
|                 1 | --spring.output.ansi.enabled=always |
|                 1 | Spring42                            |
|                 1 | SPRINGRX                            |
|                 1 | 2020-01-01                          |
+-------------------+-------------------------------------+
4 rows in set (0.00 sec)

mysql> select * from task_lock;
Empty set (0.00 sec)

mysql> select * from task_seq;
+----+------------+
| ID | UNIQUE_KEY |
+----+------------+
|  1 | 0          |
+----+------------+
1 row in set (0.00 sec)

mysql> select * from task_task_batch;
Empty set (0.00 sec)
```


Spring44
SPRINGRV
2021-01-01


```
mysql>
mysql> select * from task_execution;
+-------------------+---------------------+---------------------+----------------+-----------+--------------+---------------+---------------------+-----------------------+---------------------+
| TASK_EXECUTION_ID | START_TIME          | END_TIME            | TASK_NAME      | EXIT_CODE | EXIT_MESSAGE | ERROR_MESSAGE | LAST_UPDATED        | EXTERNAL_EXECUTION_ID | PARENT_EXECUTION_ID |
+-------------------+---------------------+---------------------+----------------+-----------+--------------+---------------+---------------------+-----------------------+---------------------+
|                 1 | 2020-01-05 02:13:51 | 2020-01-05 02:13:51 | Toll Processor |         0 | NULL         | NULL          | 2020-01-05 02:13:51 | NULL                  |                NULL |
|                 2 | 2020-01-05 02:19:54 | 2020-01-05 02:19:54 | Toll Processor |         0 | NULL         | NULL          | 2020-01-05 02:19:54 | NULL                  |                NULL |
+-------------------+---------------------+---------------------+----------------+-----------+--------------+---------------+---------------------+-----------------------+---------------------+
2 rows in set (0.00 sec)

mysql> select * from task_execution_params;
+-------------------+-------------------------------------+
| TASK_EXECUTION_ID | TASK_PARAM                          |
+-------------------+-------------------------------------+
|                 1 | --spring.output.ansi.enabled=always |
|                 1 | Spring42                            |
|                 1 | SPRINGRX                            |
|                 1 | 2020-01-01                          |
|                 2 | --spring.output.ansi.enabled=always |
|                 2 | Spring44                            |
|                 2 | SPRINGRV                            |
|                 2 | 2021-01-01                          |
+-------------------+-------------------------------------+
8 rows in set (0.00 sec)
```
