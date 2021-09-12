# 변경사항

***
### 210912
board 테이블 column 변경, 테이블 이름 변경 ( boardComment > comment ), 컬럼 추가

###### alter table board change writer view_count bigint;
###### rename table board_comment to comment;
###### alter table comment add registered_at datetime;
