INSERT INTO entry_package(id, created_date, last_update, description, name, price) VALUES(nextval('entry_package_id_seq'), now(), now(), 'FAMILY PASS ( 2 + 2 )', 'PACKAGE A', 198);
INSERT INTO entry_package(id, created_date, last_update, description, name, price) VALUES(nextval('entry_package_id_seq'), now(), now(), 'ANNUAL PASS KIDS', 'PACKAGE B', 200);
INSERT INTO entry_package(id, created_date, last_update, description, name, price) VALUES(nextval('entry_package_id_seq'), now(), now(), 'ANNUAL PASS ADULTS', 'PACKAGE C', 100);

INSERT INTO single_entry_pass(id, created_date, last_update, type, description, standard_rate, my_kad_or_my_kid_rate) VALUES(nextval('single_entry_pass_id_seq'), now(), now(), 'KIDS', '( 3-17 )', 88, 68);
INSERT INTO single_entry_pass(id, created_date, last_update, type, description, standard_rate, my_kad_or_my_kid_rate) VALUES(nextval('single_entry_pass_id_seq'), now(), now(), 'ADULTS', '( 18-59 )', 58, 38);
INSERT INTO single_entry_pass(id, created_date, last_update, type, description, standard_rate, my_kad_or_my_kid_rate) VALUES(nextval('single_entry_pass_id_seq'), now(), now(), 'SENIOR', '( 60+ )', 10, 10);
INSERT INTO single_entry_pass(id, created_date, last_update, type, description, standard_rate, my_kad_or_my_kid_rate) VALUES(nextval('single_entry_pass_id_seq'), now(), now(), 'FAMILY', '( 2A+2K )', null, 168);

INSERT INTO annual_pass(id, created_date, last_update, type, description, price) VALUES(nextval('annual_pass_id_seq'), now(), now(), 'KIDS', '( 3-17 )', 268);
INSERT INTO annual_pass(id, created_date, last_update, type, description, price) VALUES(nextval('annual_pass_id_seq'), now(), now(), 'ADULTS', '( 18-59 )', 148);

INSERT INTO big_london_admission_fee(id, created_date, last_update, type, description, adults_standard_rate, adults_mykrate, kids_or_sr_citizen_standard_rate, kids_or_sr_citizen_mykrate) VALUES(nextval('big_london_admission_fee_id_seq'), now(), now(), 'VIP', '*', 160, 120, 130, 100);
INSERT INTO big_london_admission_fee(id, created_date, last_update, type, description, adults_standard_rate, adults_mykrate, kids_or_sr_citizen_standard_rate, kids_or_sr_citizen_mykrate) VALUES(nextval('big_london_admission_fee_id_seq'), now(), now(), 'PLATINUM', '*', 130, 100, 100, 80);
INSERT INTO big_london_admission_fee(id, created_date, last_update, type, description, adults_standard_rate, adults_mykrate, kids_or_sr_citizen_standard_rate, kids_or_sr_citizen_mykrate) VALUES(nextval('big_london_admission_fee_id_seq'), now(), now(), 'GOLD', null, 80, 60, 60, 45);
INSERT INTO big_london_admission_fee(id, created_date, last_update, type, description, adults_standard_rate, adults_mykrate, kids_or_sr_citizen_standard_rate, kids_or_sr_citizen_mykrate) VALUES(nextval('big_london_admission_fee_id_seq'), now(), now(), 'SILVER', null, 50, 40, 35, 25);
INSERT INTO big_london_admission_fee(id, created_date, last_update, type, description, adults_standard_rate, adults_mykrate, kids_or_sr_citizen_standard_rate, kids_or_sr_citizen_mykrate) VALUES(nextval('big_london_admission_fee_id_seq'), now(), now(), 'BRONZE', null, 40, 30, 25, 18);

--Users--
INSERT INTO app_user(id, created_date, last_update, role, display_name, first_name, email, password) 
VALUES(nextval('app_user_id_seq'), now(), now(), 'USER', 'user1', 'user1', 'user1@themepark.com', 'themepark');
INSERT INTO app_user(id, created_date, last_update, role, display_name, first_name, email, password) 
VALUES(nextval('app_user_id_seq'), now(), now(), 'USER', 'user2', 'user2', 'user2@themepark.com', 'themepark');
INSERT INTO app_user(id, created_date, last_update, role, display_name, first_name, email, password) 
VALUES(nextval('app_user_id_seq'), now(), now(), 'USER', 'user3', 'user3', 'user3@themepark.com', 'themepark');
INSERT INTO app_user(id, created_date, last_update, role, display_name, first_name, email, password) 
VALUES(nextval('app_user_id_seq'), now(), now(), 'USER', 'user4', 'user4', 'user4@themepark.com', 'themepark');
INSERT INTO app_user(id, created_date, last_update, role, display_name, first_name, email, password) 
VALUES(nextval('app_user_id_seq'), now(), now(), 'USER', 'user5', 'user5', 'user5@themepark.com', 'themepark');
INSERT INTO app_user(id, created_date, last_update, role, display_name, first_name, email, password) 
VALUES(nextval('app_user_id_seq'), now(), now(), 'USER', 'user6', 'user6', 'user6@themepark.com', 'themepark');
INSERT INTO app_user(id, created_date, last_update, role, display_name, first_name, email, password) 
VALUES(nextval('app_user_id_seq'), now(), now(), 'USER', 'user7', 'user7', 'user7@themepark.com', 'themepark');
INSERT INTO app_user(id, created_date, last_update, role, display_name, first_name, email, password) 
VALUES(nextval('app_user_id_seq'), now(), now(), 'USER', 'user8', 'user8', 'user8@themepark.com', 'themepark');
INSERT INTO app_user(id, created_date, last_update, role, display_name, first_name, email, password) 
VALUES(nextval('app_user_id_seq'), now(), now(), 'USER', 'user9', 'user9', 'user9@themepark.com', 'themepark');
INSERT INTO app_user(id, created_date, last_update, role, display_name, first_name, email, password) 
VALUES(nextval('app_user_id_seq'), now(), now(), 'USER', 'user10', 'user10', 'user10@themepark.com', 'themepark');

INSERT INTO app_user(id, created_date, last_update, role, display_name, first_name, email, password) 
VALUES(nextval('app_user_id_seq'), now(), now(), 'SUPER_ADMIN', 'super admin', 'super admin', 'super_admin@themepark.com', 'superadmin@tp');