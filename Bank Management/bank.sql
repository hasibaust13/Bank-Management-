USE [master]
GO
/****** Object:  Database [BANK]    Script Date: 24-Mar-15 12:28:46 AM ******/
CREATE DATABASE [BANK]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'BANK', FILENAME = N'D:\Install soft\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\BANK.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'BANK_log', FILENAME = N'D:\Install soft\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\BANK_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [BANK] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [BANK].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [BANK] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [BANK] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [BANK] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [BANK] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [BANK] SET ARITHABORT OFF 
GO
ALTER DATABASE [BANK] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [BANK] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [BANK] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [BANK] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [BANK] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [BANK] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [BANK] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [BANK] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [BANK] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [BANK] SET  DISABLE_BROKER 
GO
ALTER DATABASE [BANK] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [BANK] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [BANK] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [BANK] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [BANK] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [BANK] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [BANK] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [BANK] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [BANK] SET  MULTI_USER 
GO
ALTER DATABASE [BANK] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [BANK] SET DB_CHAINING OFF 
GO
ALTER DATABASE [BANK] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [BANK] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [BANK] SET DELAYED_DURABILITY = DISABLED 
GO
USE [BANK]
GO
/****** Object:  Table [dbo].[ACCOUNT]    Script Date: 24-Mar-15 12:28:46 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ACCOUNT](
	[account_id] [int] NOT NULL,
	[customer_id] [int] NOT NULL,
	[date_opened] [datetime] NULL,
	[date_closed] [datetime] NULL,
	[current_blance] [money] NULL,
 CONSTRAINT [PK_ACCOUNT] PRIMARY KEY CLUSTERED 
(
	[account_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ADDRESSES]    Script Date: 24-Mar-15 12:28:47 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ADDRESSES](
	[address_id] [int] IDENTITY(1,1) NOT NULL,
	[house_no] [varchar](50) NULL,
	[road_no] [varchar](50) NULL,
	[zip_code] [varchar](50) NULL,
	[city] [varchar](50) NULL,
	[country] [varchar](50) NULL,
 CONSTRAINT [PK_ADDRESS] PRIMARY KEY CLUSTERED 
(
	[address_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[BRANCH]    Script Date: 24-Mar-15 12:28:47 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[BRANCH](
	[branch_id] [int] IDENTITY(1,1) NOT NULL,
	[branch_name] [varchar](50) NULL,
	[branch_location] [varchar](50) NULL,
 CONSTRAINT [PK_BRANCH] PRIMARY KEY CLUSTERED 
(
	[branch_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[CUSTOMER]    Script Date: 24-Mar-15 12:28:47 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[CUSTOMER](
	[customer_id] [int] IDENTITY(1,1) NOT NULL,
	[address_id] [int] NULL,
	[customer_name] [varchar](50) NULL,
	[customer_phone] [varchar](50) NULL,
	[customer_email] [varchar](50) NULL,
 CONSTRAINT [PK_CUSTOMER] PRIMARY KEY CLUSTERED 
(
	[customer_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[EMPLOYEE]    Script Date: 24-Mar-15 12:28:47 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[EMPLOYEE](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[user_name] [varchar](50) NULL,
	[password] [varchar](50) NULL,
 CONSTRAINT [PK_EMPLOYEE] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TRANSACTIONS]    Script Date: 24-Mar-15 12:28:47 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TRANSACTIONS](
	[transaction_id] [int] IDENTITY(1,1) NOT NULL,
	[account_id] [int] NOT NULL,
	[branch_id] [int] NULL,
	[date_of_transaction] [datetime] NULL,
	[amount] [money] NULL,
	[balance] [money] NULL,
	[operation] [varchar](50) NULL,
 CONSTRAINT [PK_TRANSACTION] PRIMARY KEY CLUSTERED 
(
	[transaction_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[ACCOUNT] ([account_id], [customer_id], [date_opened], [date_closed], [current_blance]) VALUES (1, 2, CAST(N'2015-03-02 00:00:00.000' AS DateTime), NULL, 200000.0000)
INSERT [dbo].[ACCOUNT] ([account_id], [customer_id], [date_opened], [date_closed], [current_blance]) VALUES (2, 1, CAST(N'2015-01-06 00:00:00.000' AS DateTime), NULL, 350000.0000)
INSERT [dbo].[ACCOUNT] ([account_id], [customer_id], [date_opened], [date_closed], [current_blance]) VALUES (3, 3, CAST(N'2015-03-20 00:00:00.000' AS DateTime), NULL, 250000.0000)
SET IDENTITY_INSERT [dbo].[ADDRESSES] ON 

INSERT [dbo].[ADDRESSES] ([address_id], [house_no], [road_no], [zip_code], [city], [country]) VALUES (1, N'370', N'20', N'1217', N'Dhaka', N'Bangladesh')
INSERT [dbo].[ADDRESSES] ([address_id], [house_no], [road_no], [zip_code], [city], [country]) VALUES (2, N'42', N'21', N'1200', N'Dhaka', N'Bangladesh')
INSERT [dbo].[ADDRESSES] ([address_id], [house_no], [road_no], [zip_code], [city], [country]) VALUES (3, N'201', N'25', N'1201', N'Dhaka', N'Bangladesh')
SET IDENTITY_INSERT [dbo].[ADDRESSES] OFF
SET IDENTITY_INSERT [dbo].[BRANCH] ON 

INSERT [dbo].[BRANCH] ([branch_id], [branch_name], [branch_location]) VALUES (1, N'dutchbangla', N'malibagh')
INSERT [dbo].[BRANCH] ([branch_id], [branch_name], [branch_location]) VALUES (2, N'jonota', N'mirpur')
SET IDENTITY_INSERT [dbo].[BRANCH] OFF
SET IDENTITY_INSERT [dbo].[CUSTOMER] ON 

INSERT [dbo].[CUSTOMER] ([customer_id], [address_id], [customer_name], [customer_phone], [customer_email]) VALUES (1, 1, N'Riad', N'0171', N'riad@da.com')
INSERT [dbo].[CUSTOMER] ([customer_id], [address_id], [customer_name], [customer_phone], [customer_email]) VALUES (2, 2, N'Mahade', N'0152', N'mahade@sd.com')
INSERT [dbo].[CUSTOMER] ([customer_id], [address_id], [customer_name], [customer_phone], [customer_email]) VALUES (3, 3, N'Saba', N'0185', N'saba@s.com')
SET IDENTITY_INSERT [dbo].[CUSTOMER] OFF
SET IDENTITY_INSERT [dbo].[EMPLOYEE] ON 

INSERT [dbo].[EMPLOYEE] ([id], [user_name], [password]) VALUES (1, N'r', N'123')
SET IDENTITY_INSERT [dbo].[EMPLOYEE] OFF
SET IDENTITY_INSERT [dbo].[TRANSACTIONS] ON 

INSERT [dbo].[TRANSACTIONS] ([transaction_id], [account_id], [branch_id], [date_of_transaction], [amount], [balance], [operation]) VALUES (1, 1, 1, CAST(N'2015-03-15 00:00:00.000' AS DateTime), 10000.0000, 160000.0000, N'Deposite')
INSERT [dbo].[TRANSACTIONS] ([transaction_id], [account_id], [branch_id], [date_of_transaction], [amount], [balance], [operation]) VALUES (2, 1, 2, CAST(N'2015-03-20 00:00:00.000' AS DateTime), 5000.0000, 155000.0000, N'Deposite')
INSERT [dbo].[TRANSACTIONS] ([transaction_id], [account_id], [branch_id], [date_of_transaction], [amount], [balance], [operation]) VALUES (3, 1, 1, CAST(N'2015-03-20 00:00:00.000' AS DateTime), 5000.0000, 150000.0000, N'Withdraw')
INSERT [dbo].[TRANSACTIONS] ([transaction_id], [account_id], [branch_id], [date_of_transaction], [amount], [balance], [operation]) VALUES (4, 2, 1, CAST(N'2015-03-20 00:00:00.000' AS DateTime), 10000.0000, 350000.0000, N'Withdraw')
INSERT [dbo].[TRANSACTIONS] ([transaction_id], [account_id], [branch_id], [date_of_transaction], [amount], [balance], [operation]) VALUES (5, 3, 2, CAST(N'2015-03-21 00:00:00.000' AS DateTime), 10000.0000, 250000.0000, N'Deposite')
INSERT [dbo].[TRANSACTIONS] ([transaction_id], [account_id], [branch_id], [date_of_transaction], [amount], [balance], [operation]) VALUES (6, 2, NULL, CAST(N'1905-07-09 00:00:00.000' AS DateTime), 1000.0000, 14900.0000, N'Withdraw')
INSERT [dbo].[TRANSACTIONS] ([transaction_id], [account_id], [branch_id], [date_of_transaction], [amount], [balance], [operation]) VALUES (7, 1, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[TRANSACTIONS] ([transaction_id], [account_id], [branch_id], [date_of_transaction], [amount], [balance], [operation]) VALUES (10, 2, NULL, NULL, NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[TRANSACTIONS] OFF
ALTER TABLE [dbo].[ACCOUNT]  WITH CHECK ADD  CONSTRAINT [FK_ACCOUNT_CUSTOMER] FOREIGN KEY([customer_id])
REFERENCES [dbo].[CUSTOMER] ([customer_id])
GO
ALTER TABLE [dbo].[ACCOUNT] CHECK CONSTRAINT [FK_ACCOUNT_CUSTOMER]
GO
ALTER TABLE [dbo].[CUSTOMER]  WITH CHECK ADD  CONSTRAINT [FK_CUSTOMER_ADDRESS] FOREIGN KEY([address_id])
REFERENCES [dbo].[ADDRESSES] ([address_id])
GO
ALTER TABLE [dbo].[CUSTOMER] CHECK CONSTRAINT [FK_CUSTOMER_ADDRESS]
GO
ALTER TABLE [dbo].[TRANSACTIONS]  WITH CHECK ADD  CONSTRAINT [FK_TRANSACTION_ACCOUNT] FOREIGN KEY([account_id])
REFERENCES [dbo].[ACCOUNT] ([account_id])
GO
ALTER TABLE [dbo].[TRANSACTIONS] CHECK CONSTRAINT [FK_TRANSACTION_ACCOUNT]
GO
ALTER TABLE [dbo].[TRANSACTIONS]  WITH CHECK ADD  CONSTRAINT [FK_TRANSACTION_BRANCH] FOREIGN KEY([branch_id])
REFERENCES [dbo].[BRANCH] ([branch_id])
GO
ALTER TABLE [dbo].[TRANSACTIONS] CHECK CONSTRAINT [FK_TRANSACTION_BRANCH]
GO
USE [master]
GO
ALTER DATABASE [BANK] SET  READ_WRITE 
GO
