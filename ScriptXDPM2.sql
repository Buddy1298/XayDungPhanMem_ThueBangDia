USE [XayDungPhanMemDB]
GO
ALTER TABLE [dbo].[TieuDeDVD] DROP CONSTRAINT [FK4vx3m4cmxigbox51oiyfykasx]
GO
ALTER TABLE [dbo].[PhieuGhiNhanThanhToanPhiTreHan] DROP CONSTRAINT [FKpjkuuc3arxwgtxxijimm5xb8]
GO
ALTER TABLE [dbo].[PhieuDatTruoc] DROP CONSTRAINT [FKr46ia6b6o9m1c17jpi165pv6p]
GO
ALTER TABLE [dbo].[PhieuDatTruoc] DROP CONSTRAINT [FKaivo1qf40u29i2ejj3w6o8npe]
GO
ALTER TABLE [dbo].[HoaDon] DROP CONSTRAINT [FK7v1wxyej848cci22kou9vyaur]
GO
ALTER TABLE [dbo].[DVD] DROP CONSTRAINT [FKjuqgojrsq370w2t4hbmdtyofx]
GO
ALTER TABLE [dbo].[CTHD] DROP CONSTRAINT [FKohmuk15p6l02kpuh0ndfbhuvr]
GO
ALTER TABLE [dbo].[CTHD] DROP CONSTRAINT [FKbnqktjsut28507ctcirt8yp3l]
GO
/****** Object:  Table [dbo].[TieuDeDVD]    Script Date: 8/9/2021 10:29:06 PM ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[TieuDeDVD]') AND type in (N'U'))
DROP TABLE [dbo].[TieuDeDVD]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 8/9/2021 10:29:06 PM ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[TaiKhoan]') AND type in (N'U'))
DROP TABLE [dbo].[TaiKhoan]
GO
/****** Object:  Table [dbo].[PhieuGhiNhanThanhToanPhiTreHan]    Script Date: 8/9/2021 10:29:06 PM ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[PhieuGhiNhanThanhToanPhiTreHan]') AND type in (N'U'))
DROP TABLE [dbo].[PhieuGhiNhanThanhToanPhiTreHan]
GO
/****** Object:  Table [dbo].[PhieuDatTruoc]    Script Date: 8/9/2021 10:29:06 PM ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[PhieuDatTruoc]') AND type in (N'U'))
DROP TABLE [dbo].[PhieuDatTruoc]
GO
/****** Object:  Table [dbo].[LoaiDVD]    Script Date: 8/9/2021 10:29:06 PM ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[LoaiDVD]') AND type in (N'U'))
DROP TABLE [dbo].[LoaiDVD]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 8/9/2021 10:29:06 PM ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[KhachHang]') AND type in (N'U'))
DROP TABLE [dbo].[KhachHang]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 8/9/2021 10:29:06 PM ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[HoaDon]') AND type in (N'U'))
DROP TABLE [dbo].[HoaDon]
GO
/****** Object:  Table [dbo].[DVD]    Script Date: 8/9/2021 10:29:06 PM ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[DVD]') AND type in (N'U'))
DROP TABLE [dbo].[DVD]
GO
/****** Object:  Table [dbo].[CTHD]    Script Date: 8/9/2021 10:29:06 PM ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[CTHD]') AND type in (N'U'))
DROP TABLE [dbo].[CTHD]
GO
/****** Object:  Table [dbo].[CTHD]    Script Date: 8/9/2021 10:29:06 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CTHD](
	[iDDVD] [bigint] NOT NULL,
	[iDHD] [bigint] NOT NULL,
	[thoiGianThue] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[iDDVD] ASC,
	[iDHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DVD]    Script Date: 8/9/2021 10:29:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DVD](
	[iDDVD] [bigint] IDENTITY(1,1) NOT NULL,
	[trangThai] [int] NOT NULL,
	[iDTieuDe] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[iDDVD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 8/9/2021 10:29:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[iDHD] [bigint] IDENTITY(1,1) NOT NULL,
	[ngayThue] [date] NULL,
	[iDKH] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[iDHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 8/9/2021 10:29:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[iDKH] [bigint] IDENTITY(1,1) NOT NULL,
	[diaChi] [varchar](255) NULL,
	[phiTreHan] [float] NOT NULL,
	[sdt] [varchar](255) NULL,
	[ten] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[iDKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LoaiDVD]    Script Date: 8/9/2021 10:29:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiDVD](
	[iDLoai] [bigint] IDENTITY(1,1) NOT NULL,
	[giaThue] [float] NOT NULL,
	[tenLoai] [varchar](255) NULL,
	[thoiGianThue] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[iDLoai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuDatTruoc]    Script Date: 8/9/2021 10:29:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuDatTruoc](
	[iDKH] [bigint] NOT NULL,
	[iDTieuDe] [bigint] NOT NULL,
	[thoiGianDat] [datetime2](7) NULL,
	[trangThai] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[iDKH] ASC,
	[iDTieuDe] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuGhiNhanThanhToanPhiTreHan]    Script Date: 8/9/2021 10:29:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuGhiNhanThanhToanPhiTreHan](
	[maPhieu] [int] IDENTITY(1,1) NOT NULL,
	[ngayThanhToan] [datetime2](7) NULL,
	[soDuNo] [float] NOT NULL,
	[soTienTra] [float] NOT NULL,
	[iDKH] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[maPhieu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 8/9/2021 10:29:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[idTk] [bigint] IDENTITY(1,1) NOT NULL,
	[matKhau] [varchar](255) NULL,
	[taiKhoan] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[idTk] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TieuDeDVD]    Script Date: 8/9/2021 10:29:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TieuDeDVD](
	[iDTieuDe] [bigint] IDENTITY(1,1) NOT NULL,
	[tenTieuDe] [varchar](255) NULL,
	[iDLoai] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[iDTieuDe] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[CTHD] ([iDDVD], [iDHD], [thoiGianThue]) VALUES (1, 1, 10)
INSERT [dbo].[CTHD] ([iDDVD], [iDHD], [thoiGianThue]) VALUES (1, 3, 10)
INSERT [dbo].[CTHD] ([iDDVD], [iDHD], [thoiGianThue]) VALUES (2, 2, 10)
INSERT [dbo].[CTHD] ([iDDVD], [iDHD], [thoiGianThue]) VALUES (2, 4, 10)
INSERT [dbo].[CTHD] ([iDDVD], [iDHD], [thoiGianThue]) VALUES (3, 5, 10)
INSERT [dbo].[CTHD] ([iDDVD], [iDHD], [thoiGianThue]) VALUES (4, 7, 10)
INSERT [dbo].[CTHD] ([iDDVD], [iDHD], [thoiGianThue]) VALUES (5, 6, 10)
INSERT [dbo].[CTHD] ([iDDVD], [iDHD], [thoiGianThue]) VALUES (6, 8, 10)
INSERT [dbo].[CTHD] ([iDDVD], [iDHD], [thoiGianThue]) VALUES (9, 8, 10)
INSERT [dbo].[CTHD] ([iDDVD], [iDHD], [thoiGianThue]) VALUES (10, 9, 10)
INSERT [dbo].[CTHD] ([iDDVD], [iDHD], [thoiGianThue]) VALUES (11, 9, 10)
GO
SET IDENTITY_INSERT [dbo].[DVD] ON 

INSERT [dbo].[DVD] ([iDDVD], [trangThai], [iDTieuDe]) VALUES (1, 1, 1)
INSERT [dbo].[DVD] ([iDDVD], [trangThai], [iDTieuDe]) VALUES (2, 1, 1)
INSERT [dbo].[DVD] ([iDDVD], [trangThai], [iDTieuDe]) VALUES (3, 1, 2)
INSERT [dbo].[DVD] ([iDDVD], [trangThai], [iDTieuDe]) VALUES (4, 2, 2)
INSERT [dbo].[DVD] ([iDDVD], [trangThai], [iDTieuDe]) VALUES (5, 1, 3)
INSERT [dbo].[DVD] ([iDDVD], [trangThai], [iDTieuDe]) VALUES (6, 1, 3)
INSERT [dbo].[DVD] ([iDDVD], [trangThai], [iDTieuDe]) VALUES (7, 0, 4)
INSERT [dbo].[DVD] ([iDDVD], [trangThai], [iDTieuDe]) VALUES (8, 0, 4)
INSERT [dbo].[DVD] ([iDDVD], [trangThai], [iDTieuDe]) VALUES (9, 1, 1)
INSERT [dbo].[DVD] ([iDDVD], [trangThai], [iDTieuDe]) VALUES (10, 1, 1)
INSERT [dbo].[DVD] ([iDDVD], [trangThai], [iDTieuDe]) VALUES (11, 1, 1)
INSERT [dbo].[DVD] ([iDDVD], [trangThai], [iDTieuDe]) VALUES (29, 0, 6)
INSERT [dbo].[DVD] ([iDDVD], [trangThai], [iDTieuDe]) VALUES (30, 0, 6)
INSERT [dbo].[DVD] ([iDDVD], [trangThai], [iDTieuDe]) VALUES (31, 1, 7)
INSERT [dbo].[DVD] ([iDDVD], [trangThai], [iDTieuDe]) VALUES (32, 1, 7)
INSERT [dbo].[DVD] ([iDDVD], [trangThai], [iDTieuDe]) VALUES (33, 0, 1)
INSERT [dbo].[DVD] ([iDDVD], [trangThai], [iDTieuDe]) VALUES (34, 1, 1)
INSERT [dbo].[DVD] ([iDDVD], [trangThai], [iDTieuDe]) VALUES (35, 0, 2)
SET IDENTITY_INSERT [dbo].[DVD] OFF
GO
SET IDENTITY_INSERT [dbo].[HoaDon] ON 

INSERT [dbo].[HoaDon] ([iDHD], [ngayThue], [iDKH]) VALUES (1, CAST(N'2020-11-29' AS Date), 1)
INSERT [dbo].[HoaDon] ([iDHD], [ngayThue], [iDKH]) VALUES (2, CAST(N'2020-11-29' AS Date), 1)
INSERT [dbo].[HoaDon] ([iDHD], [ngayThue], [iDKH]) VALUES (3, CAST(N'2020-11-29' AS Date), 1)
INSERT [dbo].[HoaDon] ([iDHD], [ngayThue], [iDKH]) VALUES (4, CAST(N'2020-11-29' AS Date), 1)
INSERT [dbo].[HoaDon] ([iDHD], [ngayThue], [iDKH]) VALUES (5, CAST(N'2020-11-29' AS Date), 1)
INSERT [dbo].[HoaDon] ([iDHD], [ngayThue], [iDKH]) VALUES (6, CAST(N'2020-11-29' AS Date), 1)
INSERT [dbo].[HoaDon] ([iDHD], [ngayThue], [iDKH]) VALUES (7, CAST(N'2020-12-01' AS Date), 1)
INSERT [dbo].[HoaDon] ([iDHD], [ngayThue], [iDKH]) VALUES (8, CAST(N'2020-12-01' AS Date), 1)
INSERT [dbo].[HoaDon] ([iDHD], [ngayThue], [iDKH]) VALUES (9, CAST(N'2020-12-01' AS Date), 2)
INSERT [dbo].[HoaDon] ([iDHD], [ngayThue], [iDKH]) VALUES (10, CAST(N'2021-08-07' AS Date), 1)
SET IDENTITY_INSERT [dbo].[HoaDon] OFF
GO
SET IDENTITY_INSERT [dbo].[KhachHang] ON 

INSERT [dbo].[KhachHang] ([iDKH], [diaChi], [phiTreHan], [sdt], [ten]) VALUES (1, N'tphcm', 0, N'0123456789', N'Huy')
INSERT [dbo].[KhachHang] ([iDKH], [diaChi], [phiTreHan], [sdt], [ten]) VALUES (2, N'tphcm', 0, N'0123456', N'chuong')
INSERT [dbo].[KhachHang] ([iDKH], [diaChi], [phiTreHan], [sdt], [ten]) VALUES (3, N'tphcm', 0, N'01234', N'thanh')
INSERT [dbo].[KhachHang] ([iDKH], [diaChi], [phiTreHan], [sdt], [ten]) VALUES (4, N'ha noi', 0, N'011122233344', N'hoang')
INSERT [dbo].[KhachHang] ([iDKH], [diaChi], [phiTreHan], [sdt], [ten]) VALUES (5, N'Quan 9', 0, N'0932421640', N'Duy')
INSERT [dbo].[KhachHang] ([iDKH], [diaChi], [phiTreHan], [sdt], [ten]) VALUES (6, N'Quan 2', 0, N'0123456899', N'Vu')
SET IDENTITY_INSERT [dbo].[KhachHang] OFF
GO
SET IDENTITY_INSERT [dbo].[LoaiDVD] ON 

INSERT [dbo].[LoaiDVD] ([iDLoai], [giaThue], [tenLoai], [thoiGianThue]) VALUES (1, 15000, N'game', 20)
INSERT [dbo].[LoaiDVD] ([iDLoai], [giaThue], [tenLoai], [thoiGianThue]) VALUES (2, 10000, N'phim', 10)
SET IDENTITY_INSERT [dbo].[LoaiDVD] OFF
GO
INSERT [dbo].[PhieuDatTruoc] ([iDKH], [iDTieuDe], [thoiGianDat], [trangThai]) VALUES (1, 2, CAST(N'2020-11-11T12:31:00.0000000' AS DateTime2), 0)
INSERT [dbo].[PhieuDatTruoc] ([iDKH], [iDTieuDe], [thoiGianDat], [trangThai]) VALUES (1, 3, CAST(N'2020-11-11T12:30:00.0000000' AS DateTime2), 0)
INSERT [dbo].[PhieuDatTruoc] ([iDKH], [iDTieuDe], [thoiGianDat], [trangThai]) VALUES (1, 4, CAST(N'2020-12-01T21:06:56.0504127' AS DateTime2), 0)
INSERT [dbo].[PhieuDatTruoc] ([iDKH], [iDTieuDe], [thoiGianDat], [trangThai]) VALUES (2, 2, CAST(N'2020-11-11T12:30:00.0000000' AS DateTime2), 0)
INSERT [dbo].[PhieuDatTruoc] ([iDKH], [iDTieuDe], [thoiGianDat], [trangThai]) VALUES (5, 3, CAST(N'2021-07-01T19:33:10.2431015' AS DateTime2), 0)
GO
SET IDENTITY_INSERT [dbo].[TaiKhoan] ON 

INSERT [dbo].[TaiKhoan] ([idTk], [matKhau], [taiKhoan]) VALUES (1, N'123456789', N'admin001')
INSERT [dbo].[TaiKhoan] ([idTk], [matKhau], [taiKhoan]) VALUES (2, N'123456789', N'admin002')
SET IDENTITY_INSERT [dbo].[TaiKhoan] OFF
GO
SET IDENTITY_INSERT [dbo].[TieuDeDVD] ON 

INSERT [dbo].[TieuDeDVD] ([iDTieuDe], [tenTieuDe], [iDLoai]) VALUES (1, N'contra', 1)
INSERT [dbo].[TieuDeDVD] ([iDTieuDe], [tenTieuDe], [iDLoai]) VALUES (2, N'the gioi dong vat', 1)
INSERT [dbo].[TieuDeDVD] ([iDTieuDe], [tenTieuDe], [iDLoai]) VALUES (3, N'vi sao dua anh toi', 2)
INSERT [dbo].[TieuDeDVD] ([iDTieuDe], [tenTieuDe], [iDLoai]) VALUES (4, N'startup', 2)
INSERT [dbo].[TieuDeDVD] ([iDTieuDe], [tenTieuDe], [iDLoai]) VALUES (6, N'lien minh huyen thoai', 1)
INSERT [dbo].[TieuDeDVD] ([iDTieuDe], [tenTieuDe], [iDLoai]) VALUES (7, N'pikachu', 1)
INSERT [dbo].[TieuDeDVD] ([iDTieuDe], [tenTieuDe], [iDLoai]) VALUES (8, N'doremon', 2)
INSERT [dbo].[TieuDeDVD] ([iDTieuDe], [tenTieuDe], [iDLoai]) VALUES (9, N'sakura', 2)
SET IDENTITY_INSERT [dbo].[TieuDeDVD] OFF
GO
ALTER TABLE [dbo].[CTHD]  WITH CHECK ADD  CONSTRAINT [FKbnqktjsut28507ctcirt8yp3l] FOREIGN KEY([iDDVD])
REFERENCES [dbo].[DVD] ([iDDVD])
GO
ALTER TABLE [dbo].[CTHD] CHECK CONSTRAINT [FKbnqktjsut28507ctcirt8yp3l]
GO
ALTER TABLE [dbo].[CTHD]  WITH CHECK ADD  CONSTRAINT [FKohmuk15p6l02kpuh0ndfbhuvr] FOREIGN KEY([iDHD])
REFERENCES [dbo].[HoaDon] ([iDHD])
GO
ALTER TABLE [dbo].[CTHD] CHECK CONSTRAINT [FKohmuk15p6l02kpuh0ndfbhuvr]
GO
ALTER TABLE [dbo].[DVD]  WITH CHECK ADD  CONSTRAINT [FKjuqgojrsq370w2t4hbmdtyofx] FOREIGN KEY([iDTieuDe])
REFERENCES [dbo].[TieuDeDVD] ([iDTieuDe])
GO
ALTER TABLE [dbo].[DVD] CHECK CONSTRAINT [FKjuqgojrsq370w2t4hbmdtyofx]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK7v1wxyej848cci22kou9vyaur] FOREIGN KEY([iDKH])
REFERENCES [dbo].[KhachHang] ([iDKH])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK7v1wxyej848cci22kou9vyaur]
GO
ALTER TABLE [dbo].[PhieuDatTruoc]  WITH CHECK ADD  CONSTRAINT [FKaivo1qf40u29i2ejj3w6o8npe] FOREIGN KEY([iDTieuDe])
REFERENCES [dbo].[TieuDeDVD] ([iDTieuDe])
GO
ALTER TABLE [dbo].[PhieuDatTruoc] CHECK CONSTRAINT [FKaivo1qf40u29i2ejj3w6o8npe]
GO
ALTER TABLE [dbo].[PhieuDatTruoc]  WITH CHECK ADD  CONSTRAINT [FKr46ia6b6o9m1c17jpi165pv6p] FOREIGN KEY([iDKH])
REFERENCES [dbo].[KhachHang] ([iDKH])
GO
ALTER TABLE [dbo].[PhieuDatTruoc] CHECK CONSTRAINT [FKr46ia6b6o9m1c17jpi165pv6p]
GO
ALTER TABLE [dbo].[PhieuGhiNhanThanhToanPhiTreHan]  WITH CHECK ADD  CONSTRAINT [FKpjkuuc3arxwgtxxijimm5xb8] FOREIGN KEY([iDKH])
REFERENCES [dbo].[KhachHang] ([iDKH])
GO
ALTER TABLE [dbo].[PhieuGhiNhanThanhToanPhiTreHan] CHECK CONSTRAINT [FKpjkuuc3arxwgtxxijimm5xb8]
GO
ALTER TABLE [dbo].[TieuDeDVD]  WITH CHECK ADD  CONSTRAINT [FK4vx3m4cmxigbox51oiyfykasx] FOREIGN KEY([iDLoai])
REFERENCES [dbo].[LoaiDVD] ([iDLoai])
GO
ALTER TABLE [dbo].[TieuDeDVD] CHECK CONSTRAINT [FK4vx3m4cmxigbox51oiyfykasx]
GO
