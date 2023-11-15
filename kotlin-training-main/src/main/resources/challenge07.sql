--================================================================
-- create table
--================================================================
CREATE OR REPLACE TABLE PERSON(
    NAME VARCHAR2(20),
    AGE NUMBER
);
--================================================================
-- insert sample data
--================================================================
insert into Person(age, name) values (14, 'Jack');
insert into Person(age, name) values (32, 'Duke');
insert into Person(age, name) values (34, 'Jeniffer');
insert into Person(age, name) values (24, 'Erik');
insert into Person(age, name) values (40, 'Susy');

--================================================================
-- CHALLENGE 07
--================================================================
-- Rewrite the sql below in Kotlin using higher order functions
-- in @see {@link CollectionExercise01.groupAdultsPerAgeGroup}
-- The grouping algorithm works as follows:
-- 1. filter out all adults of the list of persons
-- 2. sort the list by name
-- 3. group each person by their age group, e.g. 30 -> List<duke, jeniffer>
--    To calculate the age group in Kotlin do the following: age / 10 * 10
--    So, there is no need for FLOOR(...) like in SQL.
-- @return grouped adults
--================================================================
select FLOOR(p.AGE / 10)  * 10 as age_group, p.name, p.age from Person2 p
where p.age >= 18
order by age_group, name;

--================================================================
-- This query returns the following result:
--================================================================
--AgeGroup, Name,       Age,
--20        Erik	    24
--30        Duke	    32
--30        Jeniffer	34
--30        Joe	        35
--40	    Susy	    40

--================================================================
-- IMPORTANT: sql does not allow to return nested data structures.
-- So in Kotlin the result will be a Map, where the key is the AgeGroup
-- and the values a List of all the Persons, that belong to this AgeGroup.
--================================================================
--20 ->  listOf(Person(Erik,24))
--30 ->  listOf(Person(Duke,32), Person(Jeniffer,34), Person(Joe,35))
--40 ->  listOf(Person(Susy,40))