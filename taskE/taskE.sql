/*
 Navicat Premium Data Transfer

 Source Server         : taskE
 Source Server Type    : SQLite
 Source Server Version : 3030001
 Source Schema         : main

 Target Server Type    : SQLite
 Target Server Version : 3030001
 File Encoding         : 65001

 Date: 21/09/2021 21:54:00
*/

PRAGMA foreign_keys = false;

-- ----------------------------
-- Table structure for brands
-- ----------------------------
DROP TABLE IF EXISTS "brands";
CREATE TABLE "brands" (
  "id" INTEGER NOT NULL,
  "name" TEXT
);

-- ----------------------------
-- Records of brands
-- ----------------------------
INSERT INTO "brands" VALUES (90555, 'Philips');
INSERT INTO "brands" VALUES (153043, 'Apple');
INSERT INTO "brands" VALUES (152981, 'Lenovo');
INSERT INTO "brands" VALUES (439977, 'Midea');

-- ----------------------------
-- Table structure for categories
-- ----------------------------
DROP TABLE IF EXISTS "categories";
CREATE TABLE "categories" (
  "id" INTEGER NOT NULL,
  "name" TEXT,
  PRIMARY KEY ("id")
);

-- ----------------------------
-- Records of categories
-- ----------------------------
INSERT INTO "categories" VALUES (91013, 'Ноут');
INSERT INTO "categories" VALUES (237418, 'Варочные панели');
INSERT INTO "categories" VALUES (14694813, 'Наушники');

-- ----------------------------
-- Table structure for statistic
-- ----------------------------
DROP TABLE IF EXISTS "statistic";
CREATE TABLE "statistic" (
  "id" INTEGER NOT NULL,
  "date" date,
  "name" TEXT(30),
  "description" integer,
  "category_id" integer,
  "brand_id" INTEGER,
  "shows" integer,
  "clicks" integer,
  "orders" integer,
  "gmv" integer,
  PRIMARY KEY ("id")
);

-- ----------------------------
-- Records of statistic
-- ----------------------------
INSERT INTO "statistic" VALUES (1, '2021-03-23', '	Ноутбук Lenovo ThinkPad			', 784011, 91013, 152981, 423, 233, 33, 324434);
INSERT INTO "statistic" VALUES (2, '2021-04-14', '	Ноутбук Lenovo ThinkPad			', 784011, 91013, 152981, 622, 524, 44, 232413);
INSERT INTO "statistic" VALUES (3, '2021-04-14', '	Ноутбук Lenovo ThinkPad			', 784011, 91013, 152981, 562, 233, 45, 232413);
INSERT INTO "statistic" VALUES (4, '2021-06-14', '	Ноутбук Lenovo ThinkPad			', 784011, 91013, 152981, 226, 211, 23, 644464);
INSERT INTO "statistic" VALUES (5, '2021-06-14', '	Ноутбук MGN73RU/A				', 68686, 91013, 439977, 456, 311, 193, 1025446);
INSERT INTO "statistic" VALUES (6, '2021-06-14', '	Ноутбук Lenovo ThinkPad			', 784011, 91013, 152981, 175, 179, 43, 334434);
INSERT INTO "statistic" VALUES (7, '2021-08-02', '	Ноутбук Lenovo ThinkPad			', 784011, 91013, 152981, 135, 136, 23, 345434);
INSERT INTO "statistic" VALUES (8, '2021-07-15', '	Ноутбук Lenovo ThinkPad			', 784011, 91013, 152981, 165, 43, 13, 343443);
INSERT INTO "statistic" VALUES (9, '2021-05-14', '	Ноутбук APPLE MacBook Pro 13	', 730972, 91013, 153043, 143, 34, 23, 3434);
INSERT INTO "statistic" VALUES (10, '2021-07-17', '	Ноутбук APPLE MacBook Air 13	', 793137, 91013, 153043, 3833, 453, 43, 234333);
INSERT INTO "statistic" VALUES (11, '2021-04-14', '	Ноутбук APPLE MacBook Air 13	', 793137, 91013, 153043, 394, 233, 32, 2342443);
INSERT INTO "statistic" VALUES (12, '2021-08-14', '	Варочная панель Maunfeld		', 702254, 237418, 7085802, 16, 13, 12, 23432334);
INSERT INTO "statistic" VALUES (13, '2021-04-20', '	Варочная панель ПВИ 4000 GEFEST	', 708146, 237418, 152771, 11, 11, 10, 2342343);

PRAGMA foreign_keys = true;
