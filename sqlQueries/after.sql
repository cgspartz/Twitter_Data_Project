

-- Q3 done
-- Execution times post optimization: 3.0123, 2.9961, 2.9929, 2.9569, 3.0078
    SELECT count(DISTINCT u.state) as numStates, group_concat(DISTINCT u.state) as listOfStates, h.name
    FROM tweet as t 
    JOIN user as u on t.posterName = u.screen_name
    JOIN hashtag as h on t.tid = h.tweet_id
    WHERE year(t.createdTime) = 2016 and u.state not in (SELECT state FROM user WHERE state="na")
    GROUP BY h.name
    ORDER BY count(DISTINCT u.state) DESC
    LIMIT 5;

-- Q7 done
-- Execution times post optimization: 0.0349, 0.0031, 0.0025, 0.0024, 0.0024
    SELECT count(h.tweet_id) as tweetCount, u.screen_name, u.category
    FROM hashtag as h 
    JOIN tweet as t on h.tweet_id = t.tid
    JOIN user as u on t.posterName = u.screen_name
    WHERE h.name = "GOPDebate" and u.state = "North Carolina" and month(t.createdTime) = 2
    GROUP BY u.screen_name
    ORDER BY count(h.tweet_id) DESC
    LIMIT 5;
    
    


-- Q9 done
-- Execution times post optimization: 0.0046, 0.0005, 0.0004, 0.0003, 0.0122
    SELECT screen_name, subcategory, numFollowers
    FROM user
    WHERE subcategory = "GOP"
    ORDER BY numFollowers DESC
    LIMIT 5;

-- Q16 done
-- Execution times post optimization: 0.2135, 0.0387, 0.0390, 0.0387, 0.0388
    SELECT u.name, u.category, t.textbody, t.retweet_count, ur.address
    FROM tweet as t
    JOIN user as u on t.posterName = u.screen_name
    JOIN url as ur on t.tid = ur.tweet_id
    WHERE month(t.createdTime) = 2 and year(t.createdTime) = 2016 
    ORDER BY t.retweet_count DESC
    LIMIT 5;
    
-- Q18 done
-- Execution times post optimization: 0.1992, 0.1886, 0.1923, 0.1892, 0.1886
    SELECT m.mention_name, u2.state, group_concat(DISTINCT t.posterName) as postingUser
    FROM tweet as t 
    JOIN user as u on t.posterName = u.screen_name
    JOIN mention as m on t.tid = m.tweet_id
    JOIN user as u2 on m.mention_name = u2.screen_name
    WHERE u.subcategory = "GOP" and t.monthPosted = 1 and t.yearPosted = 2016
    GROUP BY m.mention_name
    ORDER BY count(m.mention_name) DESC
    LIMIT 5;
    

-- Q23  done
-- execution times post optimization: 0.2569, 0.2413, 0.2446, 0.2402, 0.2441
    SELECT h.name, count(h.tweet_id) as num_uses
    FROM hashtag as h
    JOIN tweet as t on h.tweet_id = t.tid
    JOIN user as u on t.posterName = u.screen_name
    WHERE u.subcategory = "GOP" and t.yearPosted = 2016 and (t.monthPosted = 1 or t.monthPosted = 2 or t.monthPosted = 3)
    GROUP BY name
    ORDER BY count(h.tweet_id) DESC
    LIMIT 5;
    

