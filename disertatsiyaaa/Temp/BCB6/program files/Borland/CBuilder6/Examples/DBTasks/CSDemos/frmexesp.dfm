�
 TFRMEXECPROC 0  TPF0TFrmExecProcFrmExecProcLeft� Top|WidthHeightpHint_Explore the ShipOrderProc in the DmEmployee data module to see what shipping an order proc doesCaptionSales ReviewColor	clBtnFaceFont.CharsetDEFAULT_CHARSET
Font.ColorclWindowTextFont.Height�	Font.NameDefault
Font.Style OldCreateOrderPositionpoScreenCenterShowHint	OnHideFormHideOnShowFormShowPixelsPerInchx
TextHeight TPanelPanel1Left Top WidthHeight2AlignalTopTabOrder  TSpeedButtonBtnShipOrderLeft>Top
WidthNHeightHintMark current order as shippedCaption&Ship OrderEnabledOnClickBtnShipOrderClick  TDBNavigatorDBNavigatorLeft
Top
Width"Height
DataSourceDmEmployee.SalesSourceCtl3DParentCtl3DTabOrder   TBitBtnBitBtn1Left�Top
WidthJHeightHintExit and close this formCaptionE&xitTabOrderKindbkCloseStylebsNew   TPanelPanel3Left Top� WidthHeight� Hint/Customers are linked to sales in the data modelAlignalBottom
BevelInner	bvLoweredBorderWidthCaptionPanel3TabOrder 
TScrollBox	ScrollBoxLeftTopWidthHeight{HorzScrollBar.MarginVertScrollBar.MarginAlignalClientBorderStylebsNoneParentShowHintShowHint	TabOrder  TLabelLabel1Left� TopWidthQHeight	AlignmenttaRightJustifyCaptionCustomer No:FocusControlEditCUST_NO  TLabelLabel2Left�Top	Width=Height	AlignmenttaRightJustifyCaptionCompany:FocusControlEditCUSTOMER  TLabelLabel3LeftTop$Width0Height	AlignmenttaRightJustifyCaptionContact:FocusControlEditCONTACT_FIRST  TLabelLabel6LeftTop>Width6Height	AlignmenttaRightJustifyCaptionAddress:FocusControlEditADDRESS_LINE  TLabelLabel4Left&Top$Width*Height	AlignmenttaRightJustifyCaptionPhone:  TDBEditEditCUST_NOLeftTTopWidth<Height	DataFieldCUST_NO
DataSourceDmEmployee.CustomerSourceTabOrder   TDBEditEditCUSTOMERLeft?TopWidth� Height	DataFieldCUSTOMER
DataSourceDmEmployee.CustomerSourceTabOrder  TDBEditEditCONTACT_FIRSTLeft?Top Width\Height	DataFieldCONTACT_FIRST
DataSourceDmEmployee.CustomerSourceTabOrder  TDBEditEditCONTACT_LASTLeft� Top Width{Height	DataFieldCONTACT_LAST
DataSourceDmEmployee.CustomerSourceTabOrder  TDBEditEditPHONE_NOLeftTTop Width� Height	DataFieldPHONE_NO
DataSourceDmEmployee.CustomerSourceTabOrder  TDBEditEditADDRESS_LINELeft?Top;Width� Height	DataFieldADDRESS_LINE1
DataSourceDmEmployee.CustomerSourceTabOrder  TDBEditEditADDRESS_LINE2LeftTop;Width� Height	DataFieldADDRESS_LINE2
DataSourceDmEmployee.CustomerSourceTabOrder  TDBEditEditCITYLeft?TopVWidth� Height	DataFieldCITY
DataSourceDmEmployee.CustomerSourceTabOrder  TDBEditEditSTATE_PROVINCELeft� TopVWidth\Height	DataFieldSTATE_PROVINCE
DataSourceDmEmployee.CustomerSourceTabOrder  TDBEditEditCOUNTRYLeft>TopVWidth\Height	DataFieldCOUNTRY
DataSourceDmEmployee.CustomerSourceTabOrder	  TDBEditEditPOSTAL_CODELeft�TopVWidthIHeight	DataFieldPOSTAL_CODE
DataSourceDmEmployee.CustomerSourceTabOrder
  TDBCheckBoxDBCheckBox1Left�TopWidthRHeightCaptionOn Hold	DataFieldON_HOLD
DataSourceDmEmployee.CustomerSourceFont.CharsetDEFAULT_CHARSET
Font.ColorclBlackFont.Height�	Font.NameDefault
Font.StylefsBold 
ParentFontTabOrderValueChecked
True;*;YesValueUncheckedFalse; ;;NIL;No    TPanelPanel2Left Top2WidthHeight� AlignalClient
BevelInner	bvLoweredBorderWidthCaptionPanel2ParentShowHintShowHint	TabOrder TDBGridDBGrid1LeftTopWidthHeight� Hint&Select an open order to ship the orderAlignalClientBorderStylebsNone
DataSourceDmEmployee.SalesSourceTabOrder TitleFont.CharsetDEFAULT_CHARSETTitleFont.ColorclWindowTextTitleFont.Height�TitleFont.NameDefaultTitleFont.Style    TDataSourceSalesSourceDataSetDmEmployee.SalesTableEnabledOnDataChangeSalesSourceDataChangeLeft� TopP   