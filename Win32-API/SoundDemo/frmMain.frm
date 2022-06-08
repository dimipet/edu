VERSION 5.00
Object = "{6B7E6392-850A-101B-AFC0-4210102A8DA7}#1.3#0"; "COMCTL32.OCX"
Begin VB.Form frmMain 
   Caption         =   "SoundDemo Application"
   ClientHeight    =   3525
   ClientLeft      =   60
   ClientTop       =   345
   ClientWidth     =   4005
   LinkTopic       =   "Form1"
   ScaleHeight     =   3525
   ScaleWidth      =   4005
   StartUpPosition =   3  'Windows Default
   Begin VB.Timer Timer 
      Enabled         =   0   'False
      Interval        =   500
      Left            =   135
      Top             =   3030
   End
   Begin ComctlLib.ProgressBar ProgressBar 
      Height          =   270
      Left            =   1050
      TabIndex        =   14
      Top             =   60
      Width           =   2820
      _ExtentX        =   4974
      _ExtentY        =   476
      _Version        =   327682
      Appearance      =   1
   End
   Begin VB.CommandButton cmdWAVPerform 
      Caption         =   "WAV Perform"
      Height          =   420
      Left            =   1365
      TabIndex        =   13
      Top             =   3015
      Width           =   1155
   End
   Begin VB.CommandButton cmdMIDIPerform 
      Caption         =   "MIDI Perform"
      Height          =   420
      Left            =   2715
      TabIndex        =   12
      Top             =   3015
      Width           =   1170
   End
   Begin VB.Frame Frame2 
      Caption         =   "MIDI Stlyes"
      Height          =   2085
      Left            =   2070
      TabIndex        =   3
      Top             =   825
      Width           =   1830
      Begin VB.OptionButton optMIDI 
         Caption         =   "Stop MIDI File"
         Enabled         =   0   'False
         Height          =   300
         Index           =   3
         Left            =   120
         TabIndex        =   11
         Top             =   1605
         Width           =   1590
      End
      Begin VB.OptionButton optMIDI 
         Caption         =   "Resume MIDI File"
         Enabled         =   0   'False
         Height          =   240
         Index           =   2
         Left            =   120
         TabIndex        =   10
         Top             =   1185
         Width           =   1575
      End
      Begin VB.OptionButton optMIDI 
         Caption         =   "Pause MIDI File"
         Enabled         =   0   'False
         Height          =   330
         Index           =   1
         Left            =   120
         TabIndex        =   9
         Top             =   735
         Width           =   1545
      End
      Begin VB.OptionButton optMIDI 
         Caption         =   "Start MIDI File"
         Height          =   240
         Index           =   0
         Left            =   120
         TabIndex        =   8
         Top             =   360
         Width           =   1485
      End
   End
   Begin VB.Frame Frame1 
      Caption         =   "WAV Playing Style"
      Height          =   2085
      Left            =   120
      TabIndex        =   2
      Top             =   825
      Width           =   1830
      Begin VB.CheckBox chkLoopSound 
         Caption         =   "Loop Sound"
         Height          =   255
         Left            =   390
         TabIndex        =   7
         Top             =   1170
         Width           =   1275
      End
      Begin VB.OptionButton optSynch 
         Caption         =   "Be Quiet!"
         Height          =   360
         Index           =   2
         Left            =   180
         TabIndex        =   6
         Top             =   1590
         Width           =   1620
      End
      Begin VB.OptionButton optSynch 
         Caption         =   "Asynchronous"
         Height          =   315
         Index           =   1
         Left            =   180
         TabIndex        =   5
         Top             =   810
         Width           =   1590
      End
      Begin VB.OptionButton optSynch 
         Caption         =   "Synchronous"
         Height          =   270
         Index           =   0
         Left            =   180
         TabIndex        =   4
         Top             =   315
         Width           =   1530
      End
   End
   Begin VB.TextBox txtFile 
      Height          =   345
      Left            =   120
      TabIndex        =   1
      Top             =   405
      Width           =   3765
   End
   Begin VB.Label Label1 
      Caption         =   "File:"
      Height          =   225
      Left            =   135
      TabIndex        =   0
      Top             =   90
      Width           =   675
   End
End
Attribute VB_Name = "frmMain"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Option Explicit

Private Sub PlayTheSound()

   Dim lngCommand As Long
   Dim lngRet As Long

   On Error GoTo error_PlayTheSound

   Screen.MousePointer = vbHourglass

'  Stop any current sound from playing
   lngRet = PlaySound(vbNullString, 0, SoundCommands.SND_PURGE)

'  Now play the sound determined by the
'  options selected.
   If optSynch(2).Value = True Then
    '  We don't do anything else
   Else
       If optSynch(0).Value = True Then
          lngCommand = SoundCommands.SND_SYNC
       Else
          If chkLoopSound.Value = vbChecked Then
             lngCommand = SoundCommands.SND_ASYNC Or _
                            SoundCommands.SND_LOOP
          Else
             lngCommand = SoundCommands.SND_ASYNC
          End If
       End If
       lngRet = PlaySound(txtFile.Text, 0, lngCommand)
       If lngRet = 0 Then
        '  Report the error.
       End If
   End If

   Screen.MousePointer = vbDefault

   Exit Sub

error_PlayTheSound:

   Screen.MousePointer = vbDefault

   MsgBox Err.Number & "  " & Err.Description, _
       vbOKOnly + vbExclamation, "Sound Error"
       
End Sub


Private Sub cmdWAVPerform_Click()

  PlayTheSound
  
End Sub

Private Sub cmdMIDIPerform_Click()

   MIDITheFile

End Sub

Private Sub MIDITheFile()

   Dim lngRet As Long
   Dim strCommand As String

   On Error GoTo error_MIDITheFile

   Screen.MousePointer = vbHourglass

   If optMIDI(0).Value = True Then
    '  Open the file and create an alias.
       strCommand = "open " & """" & _
                    Trim$(txtFile.Text) & """" & _
                    " alias MIDIfile"
       lngRet = mciSendString(strCommand, vbNullString, 0, 0)
       If lngRet <> 0 Then
           ShowMCIError lngRet
       Else
           ProgressBar.Value = 0
           ProgressBar.Max = GetStatus("Length")
           Timer.Enabled = True
        '  Start the music.
           strCommand = "Play MIDIfile"
           lngRet = _
               mciSendString(strCommand, vbNullString, 0, 0)
           If lngRet <> 0 Then
               ShowMCIError lngRet
           Else
            '  Enable/disable where appropriate
               optMIDI(0).Enabled = False
               optMIDI(1).Enabled = True
               optMIDI(2).Enabled = False
               optMIDI(3).Enabled = True
           End If
       End If
   ElseIf optMIDI(1).Value = True Then
    '  Pause the sound.
       strCommand = "pause MIDIfile"
       lngRet = mciSendString(strCommand, vbNullString, 0, 0)
       If lngRet <> 0 Then
           ShowMCIError lngRet
       Else
        '  Enable/disable where appropriate
           optMIDI(0).Enabled = False
           optMIDI(1).Enabled = False
           optMIDI(2).Enabled = True
           optMIDI(3).Enabled = True
       End If
   ElseIf optMIDI(2).Value = True Then
    '  Resume the sound.
       strCommand = "resume MIDIfile"
       lngRet = mciSendString(strCommand, vbNullString, 0, 0)
       If lngRet <> 0 Then
           ShowMCIError lngRet
       Else
        '  Enable/disable where appropriate
           optMIDI(0).Enabled = False
           optMIDI(1).Enabled = True
           optMIDI(2).Enabled = False
           optMIDI(3).Enabled = True
       End If
   ElseIf optMIDI(3).Value = True Then
     ' Stop the sound.
       strCommand = "close MIDIfile"
       lngRet = mciSendString(strCommand, vbNullString, 0, 0)
       Timer.Enabled = False
       If lngRet <> 0 Then
           ShowMCIError lngRet
       Else
        '  Enable/disable where appropriate
           optMIDI(0).Enabled = True
           optMIDI(1).Enabled = False
           optMIDI(2).Enabled = False
           optMIDI(3).Enabled = False
       End If
   Else
    '  Do nothing
   End If

   Screen.MousePointer = vbDefault

   Exit Sub

error_MIDITheFile:

   Screen.MousePointer = vbDefault

   MsgBox Err.Number & "  " & Err.Description, _
        vbOKOnly + vbExclamation, "MIDI Error"

End Sub

Private Sub ShowMCIError(ErrorCode As Long)

On Error Resume Next

Dim lngError As Long
Dim strError As String
Dim lngRet As Long

'  Report the error.
strError = String$(129, " ")
lngError = mciGetErrorString(ErrorCode, strError, 128)
If lngError = 1 Then
    strError = Left$(strError, InStr(strError, Chr$(0)))
Else
    strError = "Unknown MIDI Error"
End If
Screen.MousePointer = vbDefault
MsgBox strError, vbOKOnly + vbExclamation, _
       "MIDI Error"
lngRet = mciSendString("Close MIDIfile", vbNullString, 0, 0)

End Sub

Private Function GetStatus(Command As String) As Integer

   Dim lngRet As Long
   Dim strReturn As String * 255
   Dim intLength As Integer
   Dim strCommand As String
      
   strCommand = "Status MIDIfile " & Command
   lngRet = mciSendString(strCommand, strReturn, 255, 0)
   
   If lngRet <> 0 Then
      ShowMCIError lngRet
      Exit Function
   End If

   intLength = InStr(strReturn, Chr$(0))
   GetStatus = Val(Left$(strReturn, intLength - 1))

End Function

Private Sub Form_Unload(Cancel As Integer)

Dim lngRet As Long

lngRet = mciSendString("Close MIDIfile", vbNullString, 0, 0)
If lngRet <> 0 Then ShowMCIError lngRet
   
End Sub

Private Sub Timer_Timer()

  Dim lngRet As Long
     
  ProgressBar.Value = GetStatus("Position")
  If ProgressBar.Value = ProgressBar.Max Then
    lngRet = mciSendString("Close MIDIfile", vbNullString, 0, 0)
    If lngRet <> 0 Then ShowMCIError lngRet
    Timer.Enabled = False
  End If

End Sub
