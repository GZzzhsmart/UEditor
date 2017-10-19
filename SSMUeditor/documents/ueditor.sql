drop table if EXISTS ueditor;
create table ueditor(
  id int primary key AUTO_INCREMENT,
  title varchar(50) not null,
  content TEXT ,
  createTime DATETIME DEFAULT  now()

)engine=innodb default charset=utf8;
