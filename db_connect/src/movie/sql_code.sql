

use nation;
-- 문제 1 곡 데이터 들고 오기 
select * from 곡;

-- 문제 2 앨번번호 2번에 있는 곡명을 다 들고 오세요 
select * from 앨범; 

select a.앨범번호, a.아티스트, b.곡명 
from 앨범 as a 
inner join 곡 as b 
on a.앨범번호 = b.앨범번호 
where a.앨범번호 = 2; 

-- 2 - 1  타이틀로 검색 하시오 
select a.앨범번호, a.아티스트, b.곡명 
from 앨범 as a 
inner join 곡 as b 
on a.앨범번호 = b.앨범번호 
where a.타이틀 = '사랑하기 때문에'; 


-- 문제 3 명랑 개봉연도, 매출액, 관객 수 , 평정, 주연 배우 이름을 출력 
-- 단 영화이름은 변경 가능하도록 처리 
select * from 영화;
select * from 출연;
select * from 배우;

-- 문제 3 출력 정보 (영화정보 , 역활 이름, 배우 이름 )
-- 영화 이름에 따라 결과값이 다르게 나오도록 설계 

select a.이름, a.개봉연도, a.매출액, a.관객수, a.평점, b.역, c.이름
from 영화 as a 
inner join 출연 as b
on a.번호 = b.영화번호
inner join 배우 as c 
on b.배우번호 = c.번호
where  a.이름 like '%기생충%';

-- 영화 데이터 입력 

select * from 영화;
select * from 출연;
select * from 배우;

-- auto_increment가 아닐 경우 
select 번호 from 영화 order by 번호 desc limit 1;

use nation;
select * from 영화;
desc 영화;
-- 영화 데이터 입력하기 
insert into 영화(번호, 이름, 개봉연도, 관객수, 평점)
		values(
			15,
			'기생충',
			2020,
			2700000, 
			9.15     
		);
                
-- 배우 데이터 입력하기  
select * from 배우;
desc 배우;
select 번호 from 배우 order by 번호 desc limit 1;
insert into 배우(번호, 이름, 출생, 키, 몸무게) values (
	20, 
    '최우식', 
    timestamp('1990-08-04'),
    178, 
    77
);

-- 출연 데이터 입력하기 
select * from 출연; 
desc 출연;
insert into 출연(영화번호, 배우번호, 역할, 역) values(
	15,
    20, 
    1,
    '기우'
);


-- 데이터 삭제 
delete from 영화 where 번호 = 15; 
delete from 배우 where 번호 = 20; 
delete from 출연 where 영화번호 = 15 and 배우번호 = 20;




-- 심볼 확인하기 
show create table 출연;

-- 트랜잭션 사용해 보기 
start transaction ;
insert into 영화(번호, 이름, 개봉연도, 관객수, 평점)
		values(
			15,
			'기생충',
			2020,
			2700000, 
			9.15     
		);

insert into 배우(번호, 이름, 출생, 키, 몸무게) values (
	20, 
    '최우식', 
    timestamp('1990-08-04'),
    178, 
    77
);

insert into 출연(영화번호, 배우번호, 역할, 역) values(
	15,
    20, 
    1,
    '기우'
);

COMMIT;

ROLLBACK;


select * from 영화;
select * from 출연;
select * from 배우;
 
 
 -- 트랜잭션 2 
start transaction ;
delete from 영화 where 번호 = 15; 
delete from 배우 where 번호 = 20; 
delete from 출연 where 영화번호 = 15 and 배우번호 = 20;
COMMIT;
ROLLBACK;

-- 트랜잭션 3 
start transaction ;
delete from 출연 where 영화번호 = 15 and 배우번호 = 20;
delete from 배우 where 번호 = 20; 
delete from 영화 where 번호 = 15; 
COMMIT;
ROLLBACK;
 

START TRANSACTION;

--  COMMIT, ROLLBACK이 나올 때까지 실행되는 모든 SQL 추적

COMMIT;

-- 모든 코드를 실행(문제가 없을 경우에)

ROLLBACK;

-- START TRANSACTION 실행 전 상태로 되돌림(문제 생기면)






use blog;
desc board;

















