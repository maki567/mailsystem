--mst_user
INSERT INTO mst_user(mail_address,password,family_name,first_name)
VALUES('yamada@gmail.com','taropw','山田','太郎');

INSERT INTO mst_address(id,company_name,company_address,corporation,company_number,staff_name1,staff_mail1,staff_number1)
VALUES('1','a','a','0','0','a','a@a','0');
INSERT INTO mst_address(id,company_name,company_address,corporation,company_number,staff_name1,staff_mail1,staff_number1)
VALUES('2','a1','a','1','0','a','a@a','0');
INSERT INTO mst_address(id,company_name,company_address,corporation,company_number,staff_name1,staff_mail1,staff_number1)
VALUES('3','a2','a','0','0','a','a@a','0');

INSERT INTO mail_history(subject,to_staff,to_company,day_time)
VALUES('業務経歴書の件でのご相談1','田中太郎','ABC','2021/03/03 12:17');

INSERT INTO mail_history(subject,to_staff,to_company,day_time)
VALUES('業務経歴書の件でのご相談2','山田太郎','DEF','2022/04/04 12:17');

INSERT INTO mail_history(subject,to_staff,to_company,day_time)
VALUES('業務経歴書の件でのご相談3','鈴木花子','GHI','2023/05/05 12:17');