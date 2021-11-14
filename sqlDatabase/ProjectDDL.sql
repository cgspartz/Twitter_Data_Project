


DROP SCHEMA IF EXISTS group50;
CREATE SCHEMA group50;
USE group50;

create table user(
	screen_name varchar(50),
    name varchar(50),
    numFollowers int,
    numFollowing int,
    category varchar(50),
    subcategory varchar(50),
    state varchar(20) not null,
    primary key(screen_name)
);

create table tweet(
	tid bigint NOT NULL,
    retweet_count int DEFAULT NULL,
    retweeted tinyint DEFAULT NULL,
    textbody varchar(280),
    createdTime datetime DEFAULT NULL,
    posterName varchar(50) NOT NULL,
    primary key(tid),
    foreign key (posterName) references user (screen_name) ON DELETE CASCADE ON UPDATE CASCADE
);

create table mention(
	tweet_id bigint NOT NULL,
    mention_name varchar(50),
    primary key(tweet_id, mention_name),
    foreign key (tweet_id) references tweet (tid) ON DELETE CASCADE,
    foreign key (mention_name) references user (screen_name) ON DELETE CASCADE ON UPDATE CASCADE
);

create table hashtag(
	tweet_id bigint NOT NULL,
    name varchar(50),
    primary key(name, tweet_id),
    foreign key (tweet_id) references tweet (tid) ON DELETE CASCADE ON UPDATE CASCADE
);

create table url(
	tweet_id bigint NOT NULL,
    address varchar(500),
    primary key(address, tweet_id),
    foreign key (tweet_id) references tweet (tid) ON DELETE CASCADE ON UPDATE CASCADE
);
