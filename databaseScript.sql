use testdb;
drop table if exists User; 
CREATE TABLE if not exists User( 
    email VARCHAR(50) NOT NULL, 
    firstName VARCHAR(10) NOT NULL, 
    lastName VARCHAR(10) NOT NULL, 
    password VARCHAR(20) NOT NULL, 
    birthday DATE NOT NULL, 
    adress_street_num VARCHAR(4) , 
    adress_street VARCHAR(30) , 
    adress_city VARCHAR(20), 
    adress_state VARCHAR(2),
    adress_zip_code VARCHAR(5),
    cash_bal DECIMAL(13,2) DEFAULT 1000,
    PPS_bal DECIMAL(13,2) DEFAULT 0,
    PRIMARY KEY (email) ); 
    insert into User(email, firstName, lastName, password, birthday, adress_street_num, adress_street, adress_city, adress_state, adress_zip_code, cash_bal, PPS_bal)
    values ('susie@gmail.com', 'Susie ', 'Guzman', 'susie1234', '2000-06-27', '1234', 'whatever street', 'detroit', 'MI', '48202','1000', '0'),
            ('sophie@gmail.com', 'Sophie', 'Pierce','sophie1234', '1999-06-15', '2468', 'yolos street', 'ides', 'CM', '24680','1000', '0'),
            ('angelo@gmail.com', 'Angelo', 'Francis','angelo1234', '2021-06-14', '4680', 'egypt street', 'lolas', 'DT', '13579','1000', '0'),
            ('rudy@gmail.com', 'Rudy', 'Smith','rudy1234', '1706-06-05', '1234', 'sign street', 'samo ne tu','MH', '09876','1000', '0'),
            ('jeannette@gmail.com', 'Jeannette ', 'Stone','jeannette1234', '2001-04-24', '0981', 'snoop street', 'kojik', 'HW', '87654','1000', '0'),
            ('root', 'default', 'default','pass1234', '0000-00-00', '0000', 'Default', 'Default', '0', '00000','1000','1000000000');
select * from User; 

create view userStats as select u.email, 
(select count(1) from Transaction s where s.buyer = u.email) as buys,      
(select count(1) from Transaction s where s.seller = u.email) as sells,
(select count(1) from NFT n where n.owner = u.email) as nftsOwned
from user u      
group by u.email;


     

use testdb;
drop table if exists NFT;
CREATE TABLE if not exists NFT( 
NFTID integer AUTO_INCREMENT,
nftName varchar(100) NOT  NULL,
nftDescription varchar(100) NOT  NULL,
nftImage varchar(1000) NOT  NULL,
creator varchar(100) NOT NULL,
owner varchar(100) NOT NULL,
mintTime datetime default now(),
price DECIMAL(13,2) default 0,
PRIMARY KEY (NFTID),
foreign key(creator) references User(email),
foreign key(owner) references User(email)
);
select * from NFT; 




create view mostCreated(creator, Num) as select creator, count(*) as Num from NFT group by creator;


use testdb;
drop table if exists Transaction;
CREATE TABLE if not exists Transaction(
transId integer AUTO_INCREMENT,
nameNFT varchar(100),
seller varchar(100),
buyer varchar(100),
transType varchar(1),
timestamp DATETIME,
price DECIMAL(13,2),
PRIMARY KEY (transId),
foreign key(seller) references User(email),
foreign key(buyer) references User(email));
select * from Transaction;










create view mostSold(seller, Num) as select seller, count(*) as Num from Transaction group by seller;
create view mostBought(buyer, Num) as select buyer, count(*) as Num from Transaction group by buyer;
create view mostOwned(nameNFT, Num) as select nameNFT, count(*) as Num from Transaction group by nameNFT;

create view paperhands
as select u.email
from user u
where (select count(1) from Transaction s where s.buyer = u.email and u.email
in(select s.seller from Transaction s where s.seller = u.email) and u.email
not in (select owner from NFT where owner = u.email))
group by u.email;

create view inactive
as select u.email
from user u
left join NFT n
on n.creator = u.email
left join Transaction s 
on s.seller = u.email or s.buyer = u.email
where
u.email is not null and
n.creator is null and
s.seller is null and
s.buyer is null
group by u.email;













