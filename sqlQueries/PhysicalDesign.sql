-- Used for Q23 and Q18
-- Optimization method: creating two new columns for month and year posted to avoid month() and year() functions
ALTER TABLE tweet
ADD monthPosted INTEGER;

ALTER TABLE tweet
ADD yearPosted INTEGER;

SET SQL_SAFE_UPDATES = 0;
UPDATE tweet
SET monthPosted = month(createdTime), yearPosted = year(createdTime);
SET SQL_SAFE_UPDATES = 1;

ALTER TABLE tweet
DROP monthPosted;

ALTER TABLE tweet
DROP yearPosted;


-- Used for Q9 Q3
-- Optimization method: creating indexes 
CREATE INDEX subCtgyIndx on user(subcategory);
CREATE INDEX stateIndx on user(state);

DROP INDEX subCtgyIndx on user;
DROP INDEX stateIndx on user;

-- Q7 Q16 
-- optimization method: increase buffer pool size
-- increased buffer pool size
SET GLOBAL innodb_buffer_pool_size=402653184;

-- base buffer pool size
SET GLOBAL innodb_buffer_pool_size=8388608;

SELECT @@innodb_buffer_pool_size;
