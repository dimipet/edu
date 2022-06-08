VERSION 5.00
Begin VB.Form frmBitBlt 
   Caption         =   "BitBlt Tuturiol"
   ClientHeight    =   7455
   ClientLeft      =   60
   ClientTop       =   390
   ClientWidth     =   8925
   LinkTopic       =   "Form1"
   ScaleHeight     =   497
   ScaleMode       =   3  'Pixel
   ScaleWidth      =   595
   StartUpPosition =   3  'Windows Default
   Begin VB.CommandButton onOffLand 
      Caption         =   "onOffLand"
      Height          =   615
      Left            =   6600
      TabIndex        =   11
      Top             =   6000
      Width           =   1335
   End
   Begin VB.CommandButton rightCmd 
      Caption         =   "RIGHT"
      Height          =   495
      Left            =   8160
      TabIndex        =   10
      Top             =   3960
      Width           =   615
   End
   Begin VB.CommandButton leftCmd 
      Caption         =   "LEFT"
      Height          =   495
      Left            =   6720
      TabIndex        =   9
      Top             =   3960
      Width           =   615
   End
   Begin VB.CommandButton downCmd 
      Caption         =   "DOWN"
      Height          =   495
      Left            =   7440
      TabIndex        =   8
      Top             =   4320
      Width           =   615
   End
   Begin VB.CommandButton upCmd 
      Caption         =   "UP"
      Height          =   495
      Left            =   7440
      TabIndex        =   7
      Top             =   3480
      Width           =   615
   End
   Begin VB.CommandButton diagDownCmd 
      Caption         =   "DIAG-DOWN"
      Height          =   495
      Left            =   7080
      TabIndex        =   6
      Top             =   2400
      Width           =   1575
   End
   Begin VB.CommandButton CmdDrawHero 
      Caption         =   "Draw Hero"
      Height          =   375
      Left            =   7080
      TabIndex        =   5
      Top             =   1560
      Width           =   1695
   End
   Begin VB.CommandButton CmdDrawMask 
      Caption         =   "Draw Mask"
      Height          =   375
      Left            =   7080
      TabIndex        =   4
      Top             =   960
      Width           =   1695
   End
   Begin VB.CommandButton CmdDrawLand 
      Caption         =   "Draw Land"
      Height          =   375
      Left            =   7080
      TabIndex        =   3
      Top             =   360
      Width           =   1695
   End
   Begin VB.PictureBox Hero 
      AutoRedraw      =   -1  'True
      Height          =   615
      Left            =   5160
      Picture         =   "frmBitBlt.frx":0000
      ScaleHeight     =   37
      ScaleMode       =   3  'Pixel
      ScaleWidth      =   37
      TabIndex        =   2
      Top             =   2880
      Visible         =   0   'False
      Width           =   615
   End
   Begin VB.PictureBox HeroMask 
      AutoRedraw      =   -1  'True
      Height          =   615
      Left            =   5160
      Picture         =   "frmBitBlt.frx":0B0A
      ScaleHeight     =   37
      ScaleMode       =   3  'Pixel
      ScaleWidth      =   37
      TabIndex        =   1
      Top             =   3600
      Visible         =   0   'False
      Width           =   615
   End
   Begin VB.PictureBox Land 
      AutoRedraw      =   -1  'True
      Height          =   4695
      Left            =   0
      Picture         =   "frmBitBlt.frx":1614
      ScaleHeight     =   309
      ScaleMode       =   3  'Pixel
      ScaleWidth      =   317
      TabIndex        =   0
      Top             =   2640
      Visible         =   0   'False
      Width           =   4815
   End
End
Attribute VB_Name = "frmBitBlt"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
'code and explanation
'http://www.vbforums.com/showthread.php?t=271014
'
'Microsoft BitBlt API
'http://support.microsoft.com/kb/147810
'http://msdn.microsoft.com/en-us/library/dd183370%28v=vs.85%29.aspx
'

Option Explicit

Private Declare Function BitBlt Lib "gdi32" _
(ByVal hDestDC As Long, ByVal x As Long, ByVal Y As Long, _
ByVal nWidth As Long, ByVal nHeight As Long, ByVal hSrcDC As Long, _
ByVal xSrc As Long, ByVal ySrc As Long, ByVal dwRop As Long) As Long
'
'
Dim diagDn As Integer
Dim movup As Integer
Dim movdown As Integer
Dim movleft As Integer
Dim movright As Integer



Public Sub cmdDrawLand_click()
    'drawLand
    BitBlt frmBitBlt.hDC, 50, 50, 300, 300, frmBitBlt.Land.hDC, 0, 0, vbSrcCopy
    ' vbSrcCopy = Copies the source bitmap to destination bitmap.
End Sub

Public Sub cmdDrawmask_click()
    'drawMask
    BitBlt frmBitBlt.hDC, 50, 50, 30, 30, frmBitBlt.HeroMask.hDC, 0, 0, vbSrcAnd
    ' vbSrcAnd = Combines pixels of the destination and source bitmap using the Boolean AND operator
End Sub

Public Sub cmdDrawHero_click()
    'drawHero
    BitBlt frmBitBlt.hDC, 50, 50, 30, 30, frmBitBlt.Hero.hDC, 0, 0, vbSrcPaint
    ' vbSrcPaint Combines pixels of the destination and source bitmap using the Boolean OR operator
End Sub



Private Sub Command1_Click()
    Dim x As Integer
    For x = 50 To 150
        BitBlt frmBitBlt.hDC, 50, 50, 300, 300, frmBitBlt.Land.hDC, 0, 0, vbSrcCopy
        BitBlt frmBitBlt.hDC, x, x, 30, 30, frmBitBlt.HeroMask.hDC, 0, 0, vbSrcAnd
        BitBlt frmBitBlt.hDC, x, x, 30, 30, frmBitBlt.Hero.hDC, 0, 0, vbSrcPaint
        BitBlt frmBitBlt.hDC, x, x, 30, 30, frmBitBlt.HeroMask.hDC, 0, 0, vbSrcAnd
        BitBlt frmBitBlt.hDC, x, x, 30, 30, frmBitBlt.Hero.hDC, 0, 0, vbSrcPaint
    Next
    
    
    
End Sub


Private Sub diagDownCmd_Click()
        diagDn = diagDn + 3
        BitBlt frmBitBlt.hDC, 50, 50, 300, 300, frmBitBlt.Land.hDC, 0, 0, vbSrcCopy
        BitBlt frmBitBlt.hDC, diagDn, diagDn, 30, 30, frmBitBlt.HeroMask.hDC, 0, 0, vbSrcAnd
        BitBlt frmBitBlt.hDC, diagDn, diagDn, 30, 30, frmBitBlt.Hero.hDC, 0, 0, vbSrcPaint
        'BitBlt frmBitBlt.hDC, diagDn, diagDn, 30, 30, frmBitBlt.HeroMask.hDC, 0, 0, vbSrcAnd
        'BitBlt frmBitBlt.hDC, diagDn, diagDn, 30, 30, frmBitBlt.Hero.hDC, 0, 0, vbSrcPaint
End Sub

Private Sub Form_Load()
    diagDn = 50
    movup = 50
    movdown = 50
    movleft = 50
    movright = 50
End Sub

Private Sub onOffLand_Click()
    BitBlt frmBitBlt.hDC, 50, 50, 300, 300, frmBitBlt.Land.hDC, 0, 0, vbSrcInvert
    'BitBlt frmBitBlt.hDC, 50, 50, 300, 300, frmBitBlt.Land.hDC, 0, 0, vbSrcCopy
    'BitBlt frmBitBlt.hDC, 50, 50, 300, 300, frmBitBlt.Land.hDC, 0, 0, vbSrcErase
    'BitBlt frmBitBlt.hDC, 50, 50, 300, 300, frmBitBlt.Land.hDC, 0, 0, vbSrcInvert
    BitBlt frmBitBlt.hDC, 50, 50, 300, 300, frmBitBlt.Land.hDC, 0, 0, vbSrcPaint
    'BitBlt frmBitBlt.hDC, 50, 50, 300, 300, frmBitBlt.Land.hDC, 0, 0, vbSrcPaint
    'BitBlt frmBitBlt.hDC, 50, 50, 300, 300, frmBitBlt.Land.hDC, 0, 0, vbSrcErase
    'BitBlt frmBitBlt.hDC, 50, 50, 300, 300, frmBitBlt.Land.hDC, 0, 0, vbSrcInvert
End Sub
