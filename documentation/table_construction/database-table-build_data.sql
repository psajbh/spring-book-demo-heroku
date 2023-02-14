DROP TABLE IF EXISTS `build_data`;


--   create table
CREATE TABLE IF NOT EXISTS `build_data` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `build_host` VARCHAR(100),	-- git.build.host
    `build_time` VARCHAR(25), -- git.build.time
    `build_version` VARCHAR(20),	-- git.build.version
    `commit_id` VARCHAR(60),        -- git.commit.id
    `commit_id_short` VARCHAR(10), -- git.commit.id.describe-short
    `commit_time` VARCHAR(25),  -- git.commit.time"-
    `commit_message_short` VARCHAR(200), -- git.commit.message.short
    `remote_origin_url` VARCHAR(200) -- git.remote.origin.url
)  ENGINE=INNODB DEFAULT CHARSET=UTF8MB4 COLLATE = UTF8MB4_0900_AI_CI;

insert into `build_data` (`build_host`, `build_time`, `build_version`, `commit_id`,
	`commit_id_short`, `commit_time`, `commit_message_short`, `remote_origin_url`) values
	('DESKTOP-RSS2Q3C','2023-02-10T18:40:53-0500','0.0.1-SNAPSHOT',
    'ec227eab53941b840680ce814eb0f6464b3b52b3',
    'ec227ea','2023-02-10T18:16:17-0500', 'zen appinfo enabled git-commit-id-plugin',
    'git@github.com:psajbh/spring-book-demo-heroku.git');



select * from build_data;

--  "git.branch" : "appInfo",
--    "git.build.host" : "DESKTOP-RSS2Q3C",
--    "git.build.time" : "2023-02-10T18:40:53-0500",
--    "git.build.user.email" : "jhart.naples@gmail.com",  
--    "git.build.user.name" : "John",
 --   "git.build.version" : "0.0.1-SNAPSHOT",
 --   "git.closest.tag.commit.count" : "",
 --   "git.closest.tag.name" : "",
--    "git.commit.id" : "ec227eab53941b840680ce814eb0f6464b3b52b3",
--    "git.commit.id.abbrev" : "ec227ea",
--    "git.commit.id.describe" : "ec227ea",
--    "git.commit.id.describe-short" : "ec227ea",
--    "git.commit.message.full" : "zen appinfo enabled git-commit-id-plugin",
--    "git.commit.message.short" : "zen appinfo enabled git-commit-id-plugin",
--    "git.commit.time" : "2023-02-10T18:16:17-0500",
--    "git.commit.user.email" : "jhart.naples@gmail.com",
--    "git.commit.user.name" : "John Hart",
--    "git.dirty" : "false",
--    "git.remote.origin.url" : "git@github.com:psajbh/spring-book-demo-heroku.git",
--    "git.tags" : ""
