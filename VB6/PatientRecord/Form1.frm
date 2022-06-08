VERSION 5.00
Begin VB.Form barboutsala 
   Caption         =   "Form1"
   ClientHeight    =   3195
   ClientLeft      =   60
   ClientTop       =   345
   ClientWidth     =   4680
   LinkTopic       =   "Form1"
   ScaleHeight     =   3195
   ScaleWidth      =   4680
   StartUpPosition =   3  'Windows Default
   Begin VB.TextBox Text3 
      Height          =   375
      Left            =   2280
      TabIndex        =   6
      Text            =   "Text3"
      Top             =   1680
      Width           =   2175
   End
   Begin VB.CommandButton Command1 
      Caption         =   "Command1"
      Height          =   495
      Left            =   1320
      TabIndex        =   4
      Top             =   2400
      Width           =   2055
   End
   Begin VB.TextBox Text2 
      Height          =   405
      Left            =   2280
      TabIndex        =   3
      Text            =   "Text2"
      Top             =   960
      Width           =   2175
   End
   Begin VB.TextBox Text1 
      Height          =   405
      Left            =   2280
      TabIndex        =   2
      Text            =   "Text1"
      Top             =   240
      Width           =   2175
   End
   Begin VB.Label Label4 
      Caption         =   "1234567890"
      Height          =   615
      Left            =   120
      TabIndex        =   7
      Top             =   2400
      Width           =   975
   End
   Begin VB.Label Label3 
      Caption         =   "AMKA"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   18
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   495
      Left            =   120
      TabIndex        =   5
      Top             =   240
      Width           =   2055
   End
   Begin VB.Label Label2 
      Caption         =   "Surname"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   18
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   495
      Left            =   120
      TabIndex        =   1
      Top             =   1680
      Width           =   1935
   End
   Begin VB.Label Label1 
      Caption         =   "Name"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   18
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   375
      Left            =   120
      TabIndex        =   0
      Top             =   960
      Width           =   1935
   End
End
Attribute VB_Name = "barboutsala"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Private Sub Command1_Click()
    Dim msg As Integer
    msg = MsgBox("Minima", 0, "Titlos MsgBox")
End Sub

Private Sub Form_Load()
    Text1.Text = ""
    
End Sub
