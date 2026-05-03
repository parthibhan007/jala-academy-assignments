DROP DATABASE IF EXISTS jala_db;
CREATE DATABASE jala_db;
USE jala_db;

CREATE TABLE salespeople (
    snum INT PRIMARY KEY,
    sname VARCHAR(50),
    city VARCHAR(50),
    comm DECIMAL(4,2)
);

CREATE TABLE cust (
    cnum INT PRIMARY KEY,
    cname VARCHAR(50),
    city VARCHAR(50),
    rating INT,
    snum INT,
    FOREIGN KEY (snum) REFERENCES salespeople(snum)
);

CREATE TABLE orders (
    onum INT PRIMARY KEY,
    amt DECIMAL(10,2),
    odate DATE,
    cnum INT,
    snum INT
);

INSERT INTO salespeople VALUES
(1001,'Peel','London',0.12),
(1002,'Serres','San Jose',0.13),
(1004,'Motika','London',0.11),
(1007,'Rafkin','Barcelona',0.15),
(1003,'Axelrod','New York',0.10);

INSERT INTO cust VALUES
(2001,'Hoffman','London',100,1001),
(2002,'Giovanne','Rome',200,1003),
(2003,'Liu','San Jose',300,1002),
(2004,'Grass','Berlin',100,1002),
(2006,'Clemens','London',300,1007),
(2007,'Pereira','Rome',100,1004),
(2008,'Test','London',200,1001);

INSERT INTO orders VALUES
(3001,18.69,'1994-10-03',2008,1007),
(3003,767.19,'1994-10-03',2001,1001),
(3002,1900.10,'1994-10-03',2007,1004),
(3005,5160.45,'1994-10-03',2003,1002),
(3006,1098.16,'1994-10-04',2008,1007),
(3009,1713.23,'1994-10-04',2002,1003),
(3007,75.75,'1994-10-05',2004,1002),
(3008,4723.00,'1994-10-05',2006,1001),
(3010,1309.95,'1994-10-06',2004,1002),
(3011,9891.88,'1994-10-06',2006,1001);

-- 1
SELECT snum, sname, city, comm FROM salespeople;

-- 2
SELECT DISTINCT snum FROM orders;

-- 3
SELECT sname, comm FROM salespeople WHERE city = 'London';

-- 4
SELECT * FROM cust WHERE rating = 100;

-- 5
SELECT onum, amt, odate FROM orders;

-- 6
SELECT * FROM cust WHERE city = 'San Jose' AND rating > 200;

-- 7
SELECT * FROM cust WHERE city = 'San Jose' OR rating > 200;

-- 8
SELECT * FROM orders WHERE amt > 1000;

-- 9
SELECT sname, city FROM salespeople 
WHERE city = 'London' AND comm > 0.10;

-- 10
SELECT * FROM cust 
WHERE NOT (rating <= 100 AND city <> 'Rome');

-- 11
SELECT * FROM salespeople 
WHERE city = 'Barcelona' OR city = 'London';

-- 12
SELECT * FROM salespeople 
WHERE comm > 0.10 AND comm < 0.12;

-- 13
SELECT * FROM cust WHERE city IS NULL;

-- 14
SELECT * FROM orders 
WHERE odate IN ('1994-10-03','1994-10-04');

-- 15
SELECT * FROM cust 
WHERE snum IN (
    SELECT snum FROM salespeople 
    WHERE sname = 'Peel' OR sname = 'Motika'
);

-- 16
SELECT * FROM cust 
WHERE cname LIKE 'A%' OR cname LIKE 'B%';

-- 17
SELECT * FROM orders 
WHERE amt IS NOT NULL AND amt <> 0;

-- 18
SELECT COUNT(DISTINCT snum) FROM orders;

-- 19
SELECT snum, odate, MAX(amt) 
FROM orders 
GROUP BY snum, odate;

-- 20
SELECT snum, MAX(amt) 
FROM orders 
GROUP BY snum 
HAVING MAX(amt) > 3000;

-- 21
SELECT odate 
FROM orders 
GROUP BY odate 
ORDER BY SUM(amt) DESC 
LIMIT 1;

-- 22
SELECT COUNT(*) FROM orders WHERE odate = '1994-10-03';

-- 23
SELECT COUNT(DISTINCT city) 
FROM cust 
WHERE city IS NOT NULL;

-- 24
SELECT cnum, MIN(amt) 
FROM orders 
GROUP BY cnum;

-- 25
SELECT cname 
FROM cust 
WHERE cname LIKE 'G%' 
ORDER BY cname 
LIMIT 1;

-- 26
SELECT CONCAT('For ', odate, ' there are ', COUNT(*), ' orders') 
FROM orders 
GROUP BY odate;

-- 27
SELECT onum, snum, amt * 0.12 AS commission 
FROM orders;

-- 28
SELECT city, MAX(rating) 
FROM cust 
GROUP BY city;

-- 29
SELECT odate, SUM(amt) 
FROM orders 
GROUP BY odate 
ORDER BY SUM(amt) DESC;

-- 30
SELECT s.sname, c.cname, s.city 
FROM salespeople s 
JOIN cust c ON s.city = c.city;

-- 31
SELECT c.cname, s.sname
FROM cust c
JOIN salespeople s ON c.snum = s.snum;

-- 32
SELECT o.onum, c.cname
FROM orders o
JOIN cust c ON o.cnum = c.cnum;

-- 33
SELECT o.onum, s.sname, c.cname
FROM orders o
JOIN salespeople s ON o.snum = s.snum
JOIN cust c ON o.cnum = c.cnum;

-- 34
SELECT * FROM cust
WHERE snum IN (
    SELECT snum FROM salespeople WHERE comm > 0.12
);

-- 35
SELECT o.onum, o.amt, o.amt * s.comm AS commission
FROM orders o
JOIN cust c ON o.cnum = c.cnum
JOIN salespeople s ON o.snum = s.snum
WHERE c.rating > 100;

-- 36
SELECT c1.cname, c2.cname, c1.rating
FROM cust c1, cust c2
WHERE c1.rating = c2.rating AND c1.cnum <> c2.cnum;

-- 37
SELECT c1.cname, c2.cname, c1.rating
FROM cust c1, cust c2
WHERE c1.rating = c2.rating AND c1.cnum < c2.cnum;

-- 38
SELECT c.cname, s.sname
FROM cust c, salespeople s;

-- 39
SELECT *
FROM cust
WHERE city IN (
    SELECT city FROM cust
    WHERE snum = (
        SELECT snum FROM salespeople WHERE sname = 'Serres'
    )
);

-- 40
SELECT c1.cname, c2.cname, c1.snum
FROM cust c1, cust c2
WHERE c1.snum = c2.snum AND c1.cnum < c2.cnum;

-- 41
SELECT s1.sname, s2.sname, s1.city
FROM salespeople s1, salespeople s2
WHERE s1.city = s2.city AND s1.snum < s2.snum;

-- 42
SELECT o1.onum, o2.onum, o1.cnum
FROM orders o1, orders o2
WHERE o1.cnum = o2.cnum AND o1.onum < o2.onum;

-- 43
SELECT cname, city
FROM cust
WHERE rating = (
    SELECT rating FROM cust WHERE cname = 'Hoffman'
);

-- 44
SELECT *
FROM orders
WHERE snum = (
    SELECT snum FROM salespeople WHERE sname = 'Motika'
);

-- 45
SELECT *
FROM orders
WHERE snum = (
    SELECT snum FROM cust WHERE cname = 'Hoffman'
);

-- 46
SELECT *
FROM orders
WHERE amt > (
    SELECT AVG(amt) FROM orders WHERE odate = '1994-10-04'
);

-- 47
SELECT AVG(comm)
FROM salespeople
WHERE city = 'London';

-- 48
SELECT *
FROM orders
WHERE snum IN (
    SELECT snum FROM cust WHERE city = 'London'
);

-- 49
SELECT DISTINCT comm
FROM salespeople
WHERE snum IN (
    SELECT snum FROM cust WHERE city = 'London'
);

-- 50
SELECT *
FROM cust
WHERE cnum > (
    SELECT snum + 1000 FROM salespeople WHERE sname = 'Serres'
);

-- 51
SELECT COUNT(*)
FROM cust
WHERE rating > (
    SELECT AVG(rating) FROM cust WHERE city = 'San Jose'
);

-- 52
SELECT *
FROM orders
WHERE cnum = (
    SELECT cnum FROM cust WHERE cname = 'Cisnerous'
);

-- 53
SELECT cname, rating
FROM cust
WHERE cnum IN (
    SELECT cnum FROM orders
    WHERE amt > (SELECT AVG(amt) FROM orders)
);

-- 54
SELECT snum, SUM(amt)
FROM orders
GROUP BY snum
HAVING SUM(amt) > (SELECT MAX(amt) FROM orders);

-- 55
SELECT *
FROM cust
WHERE cnum IN (
    SELECT cnum FROM orders WHERE odate = '1994-10-03'
);

-- 56
SELECT snum, COUNT(*)
FROM cust
GROUP BY snum
HAVING COUNT(*) > 1;

-- 57
SELECT *
FROM orders o
JOIN cust c ON o.cnum = c.cnum
WHERE o.snum = c.snum;

-- 58
SELECT *
FROM orders o
WHERE amt > (
    SELECT AVG(amt) FROM orders WHERE cnum = o.cnum
);

-- 59
SELECT odate, SUM(amt)
FROM orders
GROUP BY odate
HAVING SUM(amt) >= (
    SELECT MAX(amt) + 2000 FROM orders
);

-- 60
SELECT cname, cnum
FROM cust c
WHERE rating = (
    SELECT MAX(rating)
    FROM cust
    WHERE city = c.city
);

-- 61 (using JOIN)
SELECT DISTINCT s.*
FROM salespeople s
JOIN cust c1 ON s.city = c1.city
LEFT JOIN cust c2 ON s.snum = c2.snum AND c1.cnum = c2.cnum
WHERE c2.cnum IS NULL;

-- 61 (using correlated subquery)
SELECT *
FROM salespeople s
WHERE EXISTS (
    SELECT 1 FROM cust c
    WHERE c.city = s.city
    AND c.snum <> s.snum
);

-- 62
SELECT cnum, cname, city
FROM cust
WHERE EXISTS (
    SELECT 1 FROM cust WHERE city = 'San Jose'
);

-- 63
SELECT snum
FROM cust
GROUP BY snum
HAVING COUNT(*) > 1;

-- 64
SELECT s.snum, s.sname, s.city
FROM salespeople s
WHERE s.snum IN (
    SELECT snum FROM cust GROUP BY snum HAVING COUNT(*) > 1
);

-- 65
SELECT s.*
FROM salespeople s
WHERE s.snum IN (
    SELECT snum FROM cust GROUP BY snum HAVING COUNT(*) = 1
);

-- 66
SELECT s.*
FROM salespeople s
WHERE s.snum IN (
    SELECT snum FROM orders GROUP BY snum HAVING COUNT(*) > 1
);

-- 67 (using EXISTS)
SELECT *
FROM salespeople s
WHERE EXISTS (
    SELECT 1 FROM cust c
    WHERE c.snum = s.snum AND c.rating = 300
);

-- 68 (using JOIN)
SELECT DISTINCT s.*
FROM salespeople s
JOIN cust c ON s.snum = c.snum
WHERE c.rating = 300;

-- 69
SELECT *
FROM salespeople s
WHERE EXISTS (
    SELECT 1 FROM cust c
    WHERE c.city = s.city AND c.snum <> s.snum
);

-- 70
SELECT *
FROM cust c
WHERE EXISTS (
    SELECT 1 FROM cust c2
    JOIN orders o ON c2.cnum = o.cnum
    WHERE c2.snum = c.snum AND c2.cnum <> c.cnum
);

-- 71 (IN)
SELECT *
FROM salespeople
WHERE city IN (SELECT city FROM cust);

-- 71 (ANY)
SELECT *
FROM salespeople
WHERE city = ANY (SELECT city FROM cust);

-- 72 (EXISTS)
SELECT *
FROM salespeople s
WHERE EXISTS (
    SELECT 1 FROM cust c
    WHERE c.cname > s.sname
);

-- 73
SELECT *
FROM cust
WHERE rating > ANY (
    SELECT rating FROM cust WHERE city = 'Rome'
);

-- 74
SELECT *
FROM orders
WHERE amt > ANY (
    SELECT amt FROM orders WHERE odate = '1994-10-06'
);

-- 75 (using ANY)
SELECT *
FROM orders
WHERE amt < ANY (
    SELECT amt FROM orders o
    JOIN cust c ON o.cnum = c.cnum
    WHERE c.city = 'San Jose'
);

-- 75 (without ANY)
SELECT *
FROM orders
WHERE amt < (
    SELECT MAX(amt)
    FROM orders o
    JOIN cust c ON o.cnum = c.cnum
    WHERE c.city = 'San Jose'
);

-- 76 (using ALL)
SELECT *
FROM cust
WHERE rating > ALL (
    SELECT rating FROM cust WHERE city = 'Paris'
);

-- 76 (using NOT EXISTS)
SELECT *
FROM cust c
WHERE NOT EXISTS (
    SELECT 1 FROM cust
    WHERE city = 'Paris' AND rating >= c.rating
);

-- 77
SELECT *
FROM cust
WHERE rating >= ANY (
    SELECT rating FROM cust
    WHERE snum = (SELECT snum FROM salespeople WHERE sname = 'Serres')
);

-- 78 (using NOT IN)
SELECT *
FROM salespeople
WHERE snum NOT IN (
    SELECT snum FROM cust WHERE city = salespeople.city
);

-- 79
SELECT *
FROM orders
WHERE amt > ANY (
    SELECT amt FROM orders o
    JOIN cust c ON o.cnum = c.cnum
    WHERE c.city = 'London'
);

-- 80
SELECT s.sname, c.cname
FROM salespeople s
JOIN cust c ON s.city = c.city
WHERE s.city = 'London';

-- 81
SELECT snum, MAX(amt), MIN(amt)
FROM orders
GROUP BY snum;

-- 82
SELECT s.sname,
CASE 
    WHEN s.city IN (SELECT city FROM cust) THEN 'Has Customer'
    ELSE 'No Customer'
END
FROM salespeople s;

-- 83
SELECT s.sname,
CASE 
    WHEN EXISTS (
        SELECT 1 FROM cust c 
        WHERE c.city = s.city AND c.snum = s.snum
    )
    THEN CONCAT(s.sname, ' matched')
    ELSE CONCAT(s.sname, ' not matched')
END
FROM salespeople s;

-- 84
SELECT cname, city, rating, 'High Rating' AS status
FROM cust WHERE rating >= 200
UNION
SELECT cname, city, rating, 'Low Rating'
FROM cust WHERE rating < 200;

-- 85
SELECT s.sname, s.snum
FROM salespeople s
WHERE s.snum IN (
    SELECT snum FROM orders GROUP BY snum HAVING COUNT(*) > 1
)
UNION
SELECT c.cname, c.cnum
FROM cust c
WHERE c.cnum IN (
    SELECT cnum FROM orders GROUP BY cnum HAVING COUNT(*) > 1
)
ORDER BY 1;

-- 86
SELECT snum FROM salespeople WHERE city = 'San Jose'
UNION
SELECT cnum FROM cust WHERE city = 'San Jose'
UNION ALL
SELECT onum FROM orders WHERE odate = '1994-10-03';

-- 87
SELECT *
FROM salespeople s
WHERE city = 'London'
AND EXISTS (
    SELECT 1 FROM cust c
    WHERE c.city = 'London' AND c.snum = s.snum
);

-- 88
SELECT *
FROM salespeople s
WHERE city = 'London'
AND NOT EXISTS (
    SELECT 1 FROM cust c
    WHERE c.city = 'London' AND c.snum = s.snum
);

-- 89
SELECT s.sname, c.cname
FROM salespeople s
LEFT JOIN cust c ON s.snum = c.snum

UNION

SELECT s.sname, c.cname
FROM cust c
RIGHT JOIN salespeople s ON s.snum = c.snum;

