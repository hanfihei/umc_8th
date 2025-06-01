insert into Region VALUES (3, '2020-11-11', '2020-10-10', '지역이름' );
insert into store VALUES(2, '2020-12-20', '2020-10-10', '집', 5, '가게이름', 10);

insert into review VALUES (11,'1111-11-11', '2222-12-11', 'ddd', 5, 'dddddddd', 1, 10);

INSERT INTO mission (
    mission_id,
    name,
    point,
    text,
    status,
    store_id,
    created_at,
    updated_at
) VALUES (
             1,
             '미션 이름',
             100,
             '미션 설명입니다.',
             'ONGOING',
             1,
             NOW(),
             NOW()
         );

insert into mission VALUES (5, '2001-01-01', '2020-12-12', '2020-12-12', '미션이름', 5,'ONGOING','미션내용',1);

INSERT INTO user_mission (status, completed_date, user_id, mission_id, created_at, updated_at)
VALUES ('ONGOING', NULL, 1, 1, NOW(), NOW());