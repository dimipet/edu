VERSION 5.00
Object = "{C1A8AF28-1257-101B-8FB0-0020AF039CA3}#1.1#0"; "MCI32.OCX"
Object = "{F9043C88-F6F2-101A-A3C9-08002B2F49FB}#1.2#0"; "COMDLG32.OCX"
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
   Begin MSComDlg.CommonDialog Dialog 
      Left            =   4200
      Top             =   2640
      _ExtentX        =   847
      _ExtentY        =   847
      _Version        =   393216
   End
   Begin VB.Frame Epilogi 
      Caption         =   "Epilogi"
      Height          =   735
      Left            =   360
      TabIndex        =   1
      Top             =   360
      Width           =   3975
      Begin VB.OptionButton OptAVI 
         Caption         =   "AVI"
         Height          =   255
         Left            =   1800
         TabIndex        =   3
         Top             =   360
         Width           =   1095
      End
      Begin VB.OptionButton OptWAV 
         Caption         =   "WAV"
         Height          =   195
         Left            =   240
         TabIndex        =   2
         Top             =   360
         Width           =   975
      End
   End
   Begin MCI.MMControl MMC 
      Height          =   375
      Left            =   480
      TabIndex        =   0
      Top             =   1920
      Width           =   3540
      _ExtentX        =   6244
      _ExtentY        =   661
      _Version        =   393216
      DeviceType      =   "WaveAudio"
      FileName        =   "C:\Documents and Settings\dimitris\Desktop\win32api_projects\prjWin32_MCI_1\01_Crystal Method - Intro.wav"
   End
   Begin VB.Label Status 
      Caption         =   "Status"
      Height          =   375
      Left            =   480
      TabIndex        =   4
      Top             =   2520
      Width           =   3495
   End
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False

Private Sub OptAVI_Click()
    Dialog.Filter = "all files (*.*)|*.*|.AVI files|*.AVI"
    Dialog.FilterIndex = 2
    Dialog.ShowOpen
    MMC.DeviceType = "AVIVideo"
    MMC.FileName = Dialog.FileName
    MMC.UpdateInterval = 5
    MMC.TimeFormat = mciFormatFrames
    MMC.Command = "Open"
End Sub

Private Sub OptWAV_Click()
    Dialog.Filter = "all files (*.*)|*.*|.WAV files|*.WAV"
    Dialog.FilterIndex = 2
    Dialog.ShowOpen
    MMC.DeviceType = "WaveAudio"
    MMC.FileName = Dialog.FileName
    MMC.UpdateInterval = 5
    MMC.TimeFormat = mciformatmillisecinds
    MMC.Command = "Open"
End Sub

Private Sub MMC_StatusUpdate()
    If OptAVI Then
        Status.Caption = "Frame " & _
        MMC.Position & " of " & MMC.Length
    Else
        Status.Caption = "Milliseconds:" & _
        MMC.Position & " of " & MMC.Length
    End If
End Sub



Private Sub Form_Unload(Cancel As Integer)
    MMC.Command = "Close"
End Sub

