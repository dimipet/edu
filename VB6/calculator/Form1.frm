VERSION 5.00
Begin VB.Form Calculator 
   Caption         =   "Calculator"
   ClientHeight    =   2445
   ClientLeft      =   60
   ClientTop       =   345
   ClientWidth     =   2505
   LinkTopic       =   "Form1"
   ScaleHeight     =   2445
   ScaleWidth      =   2505
   StartUpPosition =   3  'Windows Default
   Begin VB.CommandButton Command4 
      Caption         =   "/"
      Height          =   375
      Left            =   1560
      TabIndex        =   6
      Top             =   1680
      Width           =   375
   End
   Begin VB.CommandButton Command3 
      Caption         =   "*"
      Height          =   375
      Left            =   1080
      TabIndex        =   5
      Top             =   1680
      Width           =   375
   End
   Begin VB.CommandButton Command2 
      Caption         =   "-"
      Height          =   375
      Left            =   600
      TabIndex        =   4
      Top             =   1680
      Width           =   375
   End
   Begin VB.TextBox Text3 
      Height          =   285
      Left            =   120
      TabIndex        =   3
      Text            =   "Text3"
      Top             =   1200
      Width           =   2175
   End
   Begin VB.CommandButton Command1 
      Caption         =   "+"
      Height          =   375
      Left            =   120
      TabIndex        =   2
      Top             =   1680
      Width           =   375
   End
   Begin VB.TextBox Text2 
      Height          =   285
      Left            =   1320
      TabIndex        =   1
      Text            =   "Text2"
      Top             =   360
      Width           =   975
   End
   Begin VB.TextBox Text1 
      Height          =   285
      Left            =   120
      TabIndex        =   0
      Text            =   "Text1"
      Top             =   360
      Width           =   975
   End
   Begin VB.Label Label3 
      Caption         =   "Result"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   8.25
         Charset         =   161
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   255
      Left            =   120
      TabIndex        =   9
      Top             =   960
      Width           =   1815
   End
   Begin VB.Label Label2 
      Caption         =   "B Number"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   8.25
         Charset         =   161
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   255
      Left            =   1320
      TabIndex        =   8
      Top             =   120
      Width           =   1095
   End
   Begin VB.Label Label1 
      Caption         =   "A Number"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   8.25
         Charset         =   161
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   255
      Index           =   0
      Left            =   120
      TabIndex        =   7
      Top             =   120
      Width           =   855
   End
End
Attribute VB_Name = "Calculator"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
'Function Return type   Range for expression argument
'name
'
'CBool    Boolean       Any valid String or numeric expression.
'
'CByte    Byte          0 through 255; fractions are rounded.
'
'CChar    Char          Any valid String expression; value can be 0 through 65535.
'
'CDate    Date          Any valid representation of a date and time.
'
'CDbl     Double        -1.79769313486231E+308 through -4.94065645841247E-324 for negative values;
'                       4.94065645841247E-324 through 1.79769313486231E+308 for positive values.
'
'CDec     Decimal       +/-79,228,162,514,264,337,593,543,950,335 for zero-scaled numbers,
'                       that is, numbers with no decimal places. For numbers with 28 decimal places, the range is
'                       +/-7.9228162514264337593543950335. The smallest possible non-zero number is 0.0000000000000000000000000001.
'
'CInt     Integer       -2,147,483,648 through 2,147,483,647; fractions are rounded.
'
'CLng     Long          -9,223,372,036,854,775,808 through 9,223,372,036,854,775,807; fractions are rounded.
'
'CObj     Object        Any valid expression.
'
'CShort   Short         -32,768 through 32,767; fractions are rounded.
'
'CSng     Single        -3.402823E+38 through -1.401298E-45 for negative values; 1.401298E-45 through 3.402823E+38 for positive values.
'
'CStr     String        Returns for CStr depend on the expression argument. See Returns for CStr.

Private Sub Command1_Click()
    'Text3.Text = Text1.Text + Text2.Text
    Text3.Text = CDec(Text1.Text) + CDec(Text2.Text)
    If CDec(Text3.Text) < 0 Then MsgBox "Polloi Mikroi Arithmoi.", vbExclamation + vbOKOnly, "Last Name"
    
End Sub

Private Sub Command2_Click()
    Text3.Text = CDec(Text1.Text) - CDec(Text2.Text)
End Sub

Private Sub Command3_Click()
    Text3.Text = CDec(Text1.Text) * CDec(Text2.Text)
End Sub

Private Sub Command4_Click()
    Text3.Text = CDec(Text1.Text) / CDec(Text2.Text)
End Sub

Private Sub Form_Load()
    Text1.Text = ""
    Text2.Text = ""
    Text3.Text = ""
End Sub

