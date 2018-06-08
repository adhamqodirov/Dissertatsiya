object Form1: TForm1
  Left = 284
  Top = 144
  Width = 740
  Height = 857
  Caption = 'SOAP - PostTool'
  Color = clBtnFace
  Font.Charset = DEFAULT_CHARSET
  Font.Color = clWindowText
  Font.Height = -14
  Font.Name = 'MS Sans Serif'
  Font.Style = []
  Menu = MainMenu1
  OldCreateOrder = False
  OnCreate = FormCreate
  PixelsPerInch = 120
  TextHeight = 16
  object Splitter1: TSplitter
    Left = 0
    Top = 453
    Width = 732
    Height = 3
    Cursor = crVSplit
    Align = alBottom
  end
  object Splitter2: TSplitter
    Left = 0
    Top = 105
    Width = 732
    Height = 3
    Cursor = crVSplit
    Align = alTop
  end
  object PanelTop: TPanel
    Left = 0
    Top = 0
    Width = 732
    Height = 105
    Align = alTop
    TabOrder = 0
    DesignSize = (
      732
      105)
    object Label1: TLabel
      Left = 44
      Top = 41
      Width = 27
      Height = 16
      Caption = '&URL'
      FocusControl = URL
    end
    object Label2: TLabel
      Left = 12
      Top = 73
      Width = 77
      Height = 16
      Caption = 'SOAP &Action'
      FocusControl = SOAPAction
    end
    object PostBtn: TButton
      Left = 6
      Top = 4
      Width = 92
      Height = 30
      Caption = '&Post'
      TabOrder = 0
      OnClick = PostBtnClick
    end
    object URL: TEdit
      Left = 96
      Top = 41
      Width = 611
      Height = 24
      Anchors = [akLeft, akTop, akRight]
      TabOrder = 1
    end
    object SOAPAction: TEdit
      Left = 96
      Top = 68
      Width = 611
      Height = 24
      Anchors = [akLeft, akTop, akRight]
      TabOrder = 2
    end
  end
  object PanelMid: TPanel
    Left = 0
    Top = 108
    Width = 732
    Height = 345
    Align = alClient
    TabOrder = 1
    DesignSize = (
      732
      345)
    object Label3: TLabel
      Left = 28
      Top = 16
      Width = 51
      Height = 16
      Caption = '&Request'
      FocusControl = Request
    end
    object Request: TMemo
      Left = 28
      Top = 36
      Width = 677
      Height = 288
      Anchors = [akLeft, akTop, akRight, akBottom]
      TabOrder = 0
    end
  end
  object PanelBottom: TPanel
    Left = 0
    Top = 456
    Width = 732
    Height = 345
    Align = alBottom
    TabOrder = 2
    DesignSize = (
      732
      345)
    object Label4: TLabel
      Left = 28
      Top = 12
      Width = 63
      Height = 16
      Caption = 'Re&sponse'
      FocusControl = Response
    end
    object Response: TMemo
      Left = 28
      Top = 32
      Width = 680
      Height = 297
      Anchors = [akLeft, akTop, akRight, akBottom]
      TabOrder = 0
    end
  end
  object MainMenu1: TMainMenu
    Left = 576
    Top = 8
    object File: TMenuItem
      Caption = '&File'
      object FileNew: TMenuItem
        Caption = '&New'
        OnClick = FileNewClick
      end
      object FileOpen: TMenuItem
        Caption = '&Open...'
        OnClick = FileOpenClick
      end
      object FileSave: TMenuItem
        Caption = '&Save...'
        OnClick = FileSaveClick
      end
      object FileExit: TMenuItem
        Caption = '&Exit'
        OnClick = FileExitClick
      end
    end
  end
  object HTTPReqResp1: THTTPReqResp
    Agent = 'Borland SOAP 1.1'
    UseUTF8InHeader = False
    InvokeOptions = [soIgnoreInvalidCerts]
    Left = 608
    Top = 8
  end
  object OpenDialog1: TOpenDialog
    Left = 640
    Top = 8
  end
  object SaveDialog1: TSaveDialog
    Left = 672
    Top = 8
  end
end
