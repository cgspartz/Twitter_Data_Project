set SQL_SAFE_UPDATES=0;
-- delimiter //
-- CREATE TRIGGER stateLength BEFORE INSERT ON user FOR EACH ROW BEGIN
-- 	if length(NEW.state) > 0 AND length(NEW.state) < 3
-- 		then set NEW.state = "Florida";
-- 	END IF;
-- END//

UPDATE user
SET state = "Alabama"
where state="AL";

UPDATE user
SET state = "Alaska"
where state="AK";

UPDATE user
SET state = "Arizona"
where state="AZ";

UPDATE user
SET state = "Arkansas"
where state="AR";

UPDATE user
SET state = "California"
where state="CA";

UPDATE user
SET state = "Colorado"
where state="CO";

UPDATE user
SET state = "Connecticut"
where state="CT";

UPDATE user
SET state = "Delaware"
where state="DE";

UPDATE user
SET state = "Georgia"
where state="GA"; 

UPDATE user
SET state = "Idaho"
where state="ID";

UPDATE user
SET state = "Indiana"
where state="IN";

UPDATE user
SET state = "Kansas"
where state="KS";

UPDATE user
SET state = "Kentucky"
where state="KY";

UPDATE user
SET state = "Louisiana"
where state="LA";

UPDATE user
SET state = "Maine"
where state="ME";

UPDATE user
SET state = "Maryland"
where state="MD";

UPDATE user
SET state = "Massachusetts"
where state="MA";

UPDATE user
SET state = "Michigan"
where state="MI";

UPDATE user
SET state = "Minnesota"
where state="MN";

UPDATE user
SET state = "Missouri"
where state="MO";

UPDATE user
SET state = "Montana"
where state="MT";

UPDATE user
SET state = "Nevada"
where state="NV";

UPDATE user
SET state = "New Hampshire"
where state="NH";

UPDATE user
SET state = "New Jersey"
where state="NJ";

UPDATE user
SET state = "New Mexico"
where state="NM";

UPDATE user
SET state = "New York"
where state="NY";

UPDATE user
SET state = "North Carolina"
where state="NC";

UPDATE user
SET state = "North Dakota"
where state="ND";

UPDATE user
SET state = "Ohio"
where state="OH";

UPDATE user
SET state = "Oklahoma"
where state="OK";

UPDATE user
SET state = "Oregon"
where state="OR";

UPDATE user
SET state = "Pennsylvania"
where state="PA";

UPDATE user
SET state = "Rhode Island"
where state="RI";

UPDATE user
SET state = "South Carolina"
where state="SC";

UPDATE user
SET state = "Tennessee"
where state="TN";

UPDATE user
SET state = "Texas"
where state="TX";

UPDATE user
SET state = "Utah"
where state="UT";

UPDATE user
SET state = "Vermont"
where state="VT";

UPDATE user
SET state = "Virginia"
where state="VA";

UPDATE user
SET state = "Washington"
where state="WA";

UPDATE user
SET state = "West Virginia"
where state="WV";

UPDATE user
SET state = "Wyoming"
where state="WY";

UPDATE user
SET state = "Georgia"
where state="GA";

UPDATE user
SET state = "South Dakota"
where state="SD";

UPDATE user
SET state = "Florida"
where state="FL";

UPDATE user
SET state = "Iowa"
where state="IA";

UPDATE user
SET state = "Illinois"
where state="IL";

UPDATE user
SET state = "Wisconsin"
where state="WI";

UPDATE user
SET state = "Nebraska"
where state="NE";

set SQL_SAFE_UPDATES=1;