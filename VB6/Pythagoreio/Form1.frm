VERSION 5.00
Begin VB.Form Form1 
   Caption         =   "Form1"
   ClientHeight    =   3195
   ClientLeft      =   60
   ClientTop       =   345
   ClientWidth     =   4680
   LinkTopic       =   "Form1"
   ScaleHeight     =   3195
   ScaleWidth      =   4680
   StartUpPosition =   3  'Windows Default
   Begin VB.CommandButton Command1 
      Caption         =   "Ypologise C"
      Height          =   495
      Left            =   2040
      TabIndex        =   6
      Top             =   2400
      Width           =   1815
   End
   Begin VB.TextBox Text3 
      Height          =   375
      Left            =   2040
      TabIndex        =   2
      Top             =   1680
      Width           =   1695
   End
   Begin VB.TextBox Text2 
      Height          =   375
      Left            =   2040
      TabIndex        =   1
      Top             =   1080
      Width           =   1695
   End
   Begin VB.TextBox Text1 
      Height          =   375
      Left            =   2040
      TabIndex        =   0
      Top             =   360
      Width           =   1695
   End
   Begin VB.Label Label3 
      Caption         =   "C Pleura"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   13.5
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   375
      Left            =   240
      TabIndex        =   5
      Top             =   1680
      Width           =   1455
   End
   Begin VB.Label Label2 
      Caption         =   "B Pleura"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   13.5
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   375
      Index           =   0
      Left            =   240
      TabIndex        =   4
      Top             =   1080
      Width           =   1335
   End
   Begin VB.Label Label1 
      Caption         =   "A Pleura"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   13.5
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   375
      Left            =   240
      TabIndex        =   3
      Top             =   360
      Width           =   1455
   End
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False

Private Sub Command1_Click()
    Dim plevraA As Double
    Dim plevraB As Double
    plevraA = CDbl(Text1.Text)
    plevraB = CDbl(Text2.Text)
    Text3.Text = Pythagoreio(plevraA, plevraB)
End Sub

Private Function Pythagoreio(a As Double, b As Double) As Double
    Dim temp As Double
    temp = (a * a) + (b * b)
    Pythagoreio = Sqr(temp)
End Function


