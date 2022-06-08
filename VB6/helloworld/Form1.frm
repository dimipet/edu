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
   Begin VB.CommandButton Command3 
      Caption         =   "Exit"
      Height          =   495
      Left            =   3360
      TabIndex        =   3
      Top             =   2280
      Width           =   975
   End
   Begin VB.CommandButton Command2 
      Caption         =   "Clear"
      Height          =   495
      Left            =   2040
      TabIndex        =   2
      Top             =   2280
      Width           =   1095
   End
   Begin VB.TextBox Text1 
      Height          =   735
      Left            =   840
      TabIndex        =   1
      Top             =   720
      Width           =   2895
   End
   Begin VB.CommandButton Command1 
      Caption         =   "Display Hallo"
      Height          =   495
      Left            =   480
      TabIndex        =   0
      Top             =   2280
      Width           =   1335
   End
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Private Sub Command1_Click()
    Text1.Text = "Hello World"
    'Text1.Font = "Arial"
    'Text1.FontSize = 16
    Text1.ForeColor = vbBlue
End Sub

Private Sub Command2_Click()
    Text1.Text = ""
End Sub

Private Sub Command3_Click()
    End
End Sub
