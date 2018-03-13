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