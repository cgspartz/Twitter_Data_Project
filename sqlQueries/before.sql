

-- Q3 
-- Execution times pre optimization: 3.0060, 3.0361, 3.0237, 3.0734, 3.0182
    SELECT count(DISTINCT u.state) as numStates, group_concat(DISTINCT u.state) as listOfStates, h.name
    FROM tweet as t 
    JOIN user as u on t.posterName = u.screen_name
    JOIN hashtag as h on t.tid = h.tweet_id
    WHERE year(t.createdTime) = 2016 and u.state not in (SELECT state FROM user WHERE state="na")
    GROUP BY h.name
    ORDER BY count(DISTINCT u.state) DESC
    LIMIT 5;
    

-- Q7 done
-- Execution times pre optimization: 0.0261, 0.0252, 0.0244, 0.0275, 0.0231
    SELECT count(h.tweet_id) as tweetCount, u.screen_name, u.category
    FROM hashtag as h 
    JOIN tweet as t on h.tweet_id = t.tid
    JOIN user as u on t.posterName = u.screen_name
    WHERE h.name = "GOPDebate" and u.state = "North Carolina" and month(t.createdTime) = 2
    GROUP BY u.screen_name
    ORDER BY count(h.tweet_id) DESC
    LIMIT 5;
    
    


-- Q9 done
-- Execution times pre optimization: 0.0143, 0.0155, 0.0159, 0.0149, 0.0137
    SELECT screen_name, subcategory, numFollowers
    FROM user
    WHERE subcategory = "GOP"
    ORDER BY numFollowers DESC
    LIMIT 5;

-- Q16 done
-- Execution times pre optimization: 0.1814, 0.1742, 0.1701, 0.1711, 0.1736
    SELECT u.name, u.category, t.textbody, t.retweet_count, ur.address
    FROM tweet as t
    JOIN user as u on t.posterName = u.screen_name
    JOIN url as ur on t.tid = ur.tweet_id
    WHERE month(t.createdTime) = 2 and year(t.createdTime) = 2016 
    ORDER BY t.retweet_count DESC
    LIMIT 5;
    
-- Q18 done
-- Execution times pre optimization: 1.2559, 1.4542, 1.4919, 1.4601, 1.4913
    SELECT m.mention_name, u2.state, group_concat(DISTINCT t.posterName) as postingUser
    FROM tweet as t 
    JOIN user as u on t.posterName = u.screen_name
    JOIN mention as m on t.tid = m.tweet_id
    JOIN user as u2 on m.mention_name = u2.screen_name
    WHERE u.subcategory = "GOP" and month(t.createdTime) = 1 and year(t.createdTime) = 2016
    GROUP BY m.mention_name
    ORDER BY count(m.mention_name) DESC
    LIMIT 5;
    

-- Q23  done
-- Execution times pre optimization: 1.3348, 1.3135, 1.2970, 1.3103, 1.3241
    SELECT h.name, count(h.tweet_id) as num_uses
    FROM hashtag as h
    JOIN tweet as t on h.tweet_id = t.tid
    JOIN user as u on t.posterName = u.screen_name
    WHERE u.subcategory = "GOP" and year(t.createdTime) = 2016 and (month(t.createdTime) = 1 or month(t.createdTime) = 2 or month(t.createdTime) = 3)
    GROUP BY name
    ORDER BY count(h.tweet_id) DESC
    LIMIT 5;
    

