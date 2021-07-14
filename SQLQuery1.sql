use master
create table QLSP
use QLSP
create table LoaiSanPham
(
MaLoaiSP int primary key not null,
TenLoaiSP nvarchar(25)
)
create table SanPham
(
MaSP int primary key not null,
TenSP nvarchar(25),
NhaSanXuat nvarchar(25),
MaLoaiSP int,
constraint SanPham_LoaiSanPham foreign key (MaLoaiSP) references LoaiSanPham(MaLoaiSP)
)

