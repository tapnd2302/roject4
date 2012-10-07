
CREATE DATABASE PROJECT4
GO
USE PROJECT4
GO
CREATE TABLE USERS
(
	AccountID INT IDENTITY PRIMARY KEY,
	RoleID INT,
	UserName nvarchar(50) unique not null,
	UserPassword nvarchar(50) not null,
	UserFirstName nvarchar(50),
	UserLastName nvarchar(50),
	UserBirthDay Datetime,
	UserGender bit default 1,
	UserAddress nvarchar(max),
	UserPhone nvarchar(15),
	UserEmail nvarchar(max),
	AllowLogin bit default 1
)
GO
CREATE TABLE ROLES
(
	RoleID int identity primary key,
	RoleName nvarchar(50),
	Descriptions nvarchar(100)
)
GO

CREATE TABLE HOTEL_RESTAURANT  ---HR: HOTEL & RESTAURANT
(
	HRID int identity primary key,
	AreaID int,
	HRName nvarchar(100),
	HRAddress nvarchar(200),
	HRPhone nvarchar(15),
	HREmail nvarchar(100),
	HRInfo nvarchar(max),
	HRStatus bit default 1
)
GO
CREATE TABLE TYPEROOMS
(
	TypeRoomID int identity primary key,
	TypeRoomName nvarchar(50) unique,
	TypeRoomPrice float,
	TypeRoomDescription nvarchar(max)
)
GO
CREATE TABLE ROOMS
(
	RoomID int identity primary key,
	HRID int,
	TypeRoomID int,
	RoomStatus bit default 0,
	RoomDescription nvarchar(max)
)
GO
CREATE TABLE TYPEFOODS
(
	TypeFoodID int identity primary key,
	TypeFoodName nvarchar(100),
	TypeFoodDescription nvarchar(max)	
)
GO
CREATE TABLE FOODS
(
	FoodID int identity primary key,
	TypeFoodID int,
	FoodName nvarchar(100),
	FoodPrices float,
	FoodDescription nvarchar(max),
	FoodStatus bit default 1,
)
GO
CREATE TABLE BOOKING
(
	BookingID int identity primary key,
	AccountID int,
	HRID int,         --HR: Hotel & Restaurant
	TimeStart datetime,
	TimeEnd datetime,
	BookingStatus bit default 0,
	Notes nvarchar(max),
	TokenNumber UNIQUEIDENTIFIER default newid()
)
GO
CREATE TABLE ROOMBOOKING
(
	BookingDetailsID int primary key,
	BookingID int,
	RoomID int,
)
GO
CREATE TABLE TYPETABLE
(
	TypeTableID int identity primary key,
	TypeTableName nvarchar(100),
	TypeTableDescription nvarchar(max),
	TablePrice float
)
GO

CREATE TABLE RESTAURANT_TABLES
(
	ResTableID int identity primary key,
	HRID int,
	TypeTableID int,
	StatusTable bit default 0,
	TableDescription nvarchar(max)
)
GO
CREATE TABLE TABLEBOOKING
(
	BookingDetailsID int primary key,
	BookingID int,
	ResTableID int
)
GO
CREATE TABLE NEWS
(
	NewsID int identity primary key,
	NewsTitle nvarchar(100),
	NewsContent nvarchar(max),
	AccountID int,
	TimeUpNews datetime default getdate()
)
GO
CREATE TABLE HOMEDELIVERY
(
	BookingID int identity primary key,
	AccountID int,
	DeliveryTime datetime,
	ShipMoney float,
	Total float
)
GO
CREATE TABLE HOMEDELIVERY_DETAILS
(
	DeliveryDetailsID int identity primary key,
	BookingID int,
	FoodID int,
	Quantity int,
	SubTotal float
)
GO
CREATE TABLE FEEDBACK
(
	FeedBackID int identity primary key,
	FullName nvarchar(50),
	Email nvarchar(max),
	Title nvarchar(100),
	Content nvarchar(max),
	DateCreate datetime default getdate()
)
GO
CREATE TABLE TYPEIMAGES
(
	TypeImageID int identity primary key,
	TypeName nvarchar(50),
	TypeDescription nvarchar(200)
)
GO

CREATE TABLE IMAGES
(
	ImageID int identity primary key,
	TypeImage int,  --- 1: Image of User, 2:Image of Hotel & Restaurant, 3: Image Of Room, 4: Image Of Food
	ID int,         --- ID is AccountID or HRID Or FoodID or RoomID
	Descriptions nvarchar(200),
	ImageLink nvarchar(max)
)
Go
CREATE TABLE BOOKINGPARTY
(
     Id INT IDENTITY PRIMARY KEY,
     FullName NVARCHAR(50),
     Email NVARCHAR(100),
     Phone NVARCHAR(11),
     [Address] NVARCHAR(200),
     Scale INT ,
     [Time] DATETIME,
     Conntent NVARCHAR(MAX)
)
GO


ALTER TABLE [dbo].[BOOKING]  WITH CHECK ADD  CONSTRAINT [FK_BOOKING_HOTEL_RESTAURANT] FOREIGN KEY([HRID])
REFERENCES [dbo].[HOTEL_RESTAURANT] ([HRID])
GO

ALTER TABLE [dbo].[BOOKING] CHECK CONSTRAINT [FK_BOOKING_HOTEL_RESTAURANT]
GO

ALTER TABLE [dbo].[BOOKING]  WITH CHECK ADD  CONSTRAINT [FK_BOOKING_USERS] FOREIGN KEY([AccountID])
REFERENCES [dbo].[USERS] ([AccountID])
GO

ALTER TABLE [dbo].[BOOKING] CHECK CONSTRAINT [FK_BOOKING_USERS]
GO


ALTER TABLE [dbo].[FOODS]  WITH CHECK ADD  CONSTRAINT [FK_FOODS_TYPEFOODS] FOREIGN KEY([TypeFoodID])
REFERENCES [dbo].[TYPEFOODS] ([TypeFoodID])
GO

ALTER TABLE [dbo].[FOODS] CHECK CONSTRAINT [FK_FOODS_TYPEFOODS]
GO

ALTER TABLE [dbo].[HOMEDELIVERY]  WITH CHECK ADD  CONSTRAINT [FK_HOMEDELIVERY_USERS] FOREIGN KEY([AccountID])
REFERENCES [dbo].[USERS] ([AccountID])
GO

ALTER TABLE [dbo].[HOMEDELIVERY] CHECK CONSTRAINT [FK_HOMEDELIVERY_USERS]
GO

ALTER TABLE [dbo].[HOMEDELIVERY_DETAILS]  WITH CHECK ADD  CONSTRAINT [FK_HOMEDELIVERY_DETAILS_FOODS] FOREIGN KEY([FoodID])
REFERENCES [dbo].[FOODS] ([FoodID])
GO

ALTER TABLE [dbo].[HOMEDELIVERY_DETAILS] CHECK CONSTRAINT [FK_HOMEDELIVERY_DETAILS_FOODS]
GO

ALTER TABLE [dbo].[HOMEDELIVERY_DETAILS]  WITH CHECK ADD  CONSTRAINT [FK_HOMEDELIVERY_DETAILS_HOMEDELIVERY] FOREIGN KEY([BookingID])
REFERENCES [dbo].[HOMEDELIVERY] ([BookingID])
GO

ALTER TABLE [dbo].[HOMEDELIVERY_DETAILS] CHECK CONSTRAINT [FK_HOMEDELIVERY_DETAILS_HOMEDELIVERY]
GO






ALTER TABLE [dbo].[NEWS]  WITH CHECK ADD  CONSTRAINT [FK_NEWS_USERS] FOREIGN KEY([AccountID])
REFERENCES [dbo].[USERS] ([AccountID])
GO

ALTER TABLE [dbo].[NEWS] CHECK CONSTRAINT [FK_NEWS_USERS]
GO

ALTER TABLE [dbo].[RESTAURANT_TABLES]  WITH CHECK ADD  CONSTRAINT [FK_RESTAURANT_TABLES_TYPETABLE] FOREIGN KEY([TypeTableID])
REFERENCES [dbo].[TYPETABLE] ([TypeTableID])
GO

ALTER TABLE [dbo].[RESTAURANT_TABLES] CHECK CONSTRAINT [FK_RESTAURANT_TABLES_TYPETABLE]
GO


ALTER TABLE [dbo].[ROOMBOOKING]  WITH CHECK ADD  CONSTRAINT [FK_ROOMBOOKING_ROOMS] FOREIGN KEY([RoomID])
REFERENCES [dbo].[ROOMS] ([RoomID])
GO

ALTER TABLE [dbo].[ROOMBOOKING] CHECK CONSTRAINT [FK_ROOMBOOKING_ROOMS]
GO

ALTER TABLE [dbo].[ROOMS]  WITH CHECK ADD  CONSTRAINT [FK_ROOMS_TYPEROOMS] FOREIGN KEY([TypeRoomID])
REFERENCES [dbo].[TYPEROOMS] ([TypeRoomID])
GO

ALTER TABLE [dbo].[ROOMS] CHECK CONSTRAINT [FK_ROOMS_TYPEROOMS]
GO

ALTER TABLE [dbo].[TABLEBOOKING]  WITH CHECK ADD  CONSTRAINT [FK_TABLEBOOKING_RESTAURANT_TABLES] FOREIGN KEY([ResTableID])
REFERENCES [dbo].[RESTAURANT_TABLES] ([ResTableID])
GO

ALTER TABLE [dbo].[TABLEBOOKING] CHECK CONSTRAINT [FK_TABLEBOOKING_RESTAURANT_TABLES]
GO

ALTER TABLE [dbo].[USERS]  WITH CHECK ADD  CONSTRAINT [FK_USERS_ROLES] FOREIGN KEY([RoleID])
REFERENCES [dbo].[ROLES] ([RoleID])
GO

ALTER TABLE [dbo].[USERS] CHECK CONSTRAINT [FK_USERS_ROLES]
GO
ALTER TABLE [dbo].[TABLEBOOKING]  WITH CHECK ADD  CONSTRAINT [FK_TABLEBOOKING_BOOKING] FOREIGN KEY([BookingID])
REFERENCES [dbo].[BOOKING] ([BookingID])
GO

ALTER TABLE [dbo].[TABLEBOOKING] CHECK CONSTRAINT [FK_TABLEBOOKING_BOOKING]
GO

ALTER TABLE [dbo].[ROOMBOOKING]  WITH CHECK ADD  CONSTRAINT [FK_ROOMBOOKING_BOOKING] FOREIGN KEY([BookingID])
REFERENCES [dbo].[BOOKING] ([BookingID])
GO

ALTER TABLE [dbo].[ROOMBOOKING] CHECK CONSTRAINT [FK_ROOMBOOKING_BOOKING]
GO

ALTER TABLE [dbo].[IMAGES]  WITH CHECK ADD  CONSTRAINT [FK_IMAGES_TYPEIMAGES] FOREIGN KEY([TypeImage])
REFERENCES [dbo].[TYPEIMAGES] ([TypeImageID])
GO

ALTER TABLE [dbo].[IMAGES] CHECK CONSTRAINT [FK_IMAGES_TYPEIMAGES]
GO




INSERT INTO TYPEIMAGES VALUES ('UserIMG','Image of User')
INSERT INTO TYPEIMAGES VALUES ('Hotel&Restaunrant','Hotel And Restaurant Image')
INSERT INTO TYPEIMAGES VALUES ('Room','Image of Room')
INSERT INTO TYPEIMAGES VALUES ('Food','Image of Food')


INSERT INTO TYPEFOODS VALUES ('Vegetarian','vegetarian Food')
INSERT INTO TYPEFOODS VALUES ('Salty','Salty Food')

