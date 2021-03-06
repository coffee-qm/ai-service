-- 
DROP TABLE IF EXISTS t_tasks;
CREATE TABLE t_tasks (
	id BIGINT(20) not NULL auto_increment,
	name VARCHAR(50) NULL DEFAULT NULL,
	sn VARCHAR(50) NULL DEFAULT NULL,
	description VARCHAR(200) NULL DEFAULT NULL,
	developer VARCHAR(50) NULL DEFAULT NULL,
	status INT(1) NULL DEFAULT NULL,
	codes_num BIGINT(20) NULL DEFAULT NULL,
	create_time BIGINT(13) NULL DEFAULT NULL,
	update_time BIGINT(13) NULL DEFAULT NULL,
	planed_start_time BIGINT(13) NULL DEFAULT NULL,
	planed_finish_time BIGINT(13) NULL DEFAULT NULL,
	actual_start_time BIGINT(13) NULL DEFAULT NULL,
	actual_finish_time BIGINT(13) NULL DEFAULT NULL,
	user_ip VARCHAR(50) NULL DEFAULT NULL,
	PRIMARY KEY  (id)
);
-- 
DROP TABLE IF EXISTS t_tasks_rel;
CREATE TABLE t_tasks_rel (
	id BIGINT(20) not NULL auto_increment,
	type INT(1) NULL DEFAULT NULL,
	task_id BIGINT(20) NULL DEFAULT NULL,
	rel_id BIGINT(20) NULL DEFAULT NULL,
	description VARCHAR(200) NULL DEFAULT NULL,
	create_time BIGINT(13) NULL DEFAULT NULL,
	user_ip VARCHAR(50) NULL DEFAULT NULL,
	PRIMARY KEY  (id)
);
-- 
DROP TABLE IF EXISTS t_tasks_progress;
CREATE TABLE t_tasks_progress (
	id BIGINT(20) not NULL auto_increment,
	task_id BIGINT(20) NULL DEFAULT NULL,
	rate INT(2) NULL DEFAULT 0,
	description VARCHAR(200) NULL DEFAULT NULL,
	create_time BIGINT(13) NULL DEFAULT NULL,
	update_time BIGINT(13) NULL DEFAULT NULL,
	user_ip VARCHAR(50) NULL DEFAULT NULL,
	PRIMARY KEY  (id)
);
-- 
DROP TABLE IF EXISTS t_audit;
CREATE TABLE t_audit (
	id BIGINT(20) not NULL auto_increment,
	module VARCHAR(200) NULL DEFAULT NULL,
	type INT(1) NULL DEFAULT NULL,
	data_old VARCHAR(2000) NULL DEFAULT NULL,
	data_new VARCHAR(2000) NULL DEFAULT NULL,
	create_time BIGINT(13) NULL DEFAULT NULL,
	user_ip VARCHAR(50) NULL DEFAULT NULL,
	PRIMARY KEY  (id)
);
