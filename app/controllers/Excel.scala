package controllers

import java.awt.Color

import org.apache.poi.ss.usermodel.{IndexedColors, CellStyle}
import play.api._
import play.api.mvc._
import java.io.File
import java.io.FileOutputStream
import org.apache.poi.xssf.usermodel._


object Excel extends Controller {

    def index = Action {
      val file = new File("mydata.xlsx")
      val fileOut = new FileOutputStream(file);
      val wb = new XSSFWorkbook
      val sheet = wb.createSheet("Sheet1")

      val cNum = 1

      val style = wb.createCellStyle()
      style.setBorderBottom(CellStyle.BORDER_THIN)
      style.setBottomBorderColor(IndexedColors.BLACK.getIndex())
      style.setBorderLeft(CellStyle.BORDER_THIN)
      style.setLeftBorderColor(IndexedColors.SEA_GREEN.getIndex)
      style.setBorderRight(CellStyle.BORDER_THIN)
      style.setRightBorderColor(IndexedColors.BLUE.getIndex())
      style.setBorderTop(CellStyle.BORDER_MEDIUM_DASHED)
      style.setTopBorderColor(IndexedColors.BLACK.getIndex())
      style.setFillBackgroundColor(new XSSFColor(new Color(18, 12, 45)))


      for( rNum <- 1 until 10000){
        var row = sheet.createRow(rNum)
        val cell = row.createCell(cNum)
        cell.setCellValue(s"My Cell ${rNum}:${cNum}Value")
        cell.setCellStyle(style)
      }

      wb.write(fileOut);
      fileOut.close();

      Ok.sendFile( content = file, fileName = _ => "mydata.xlsx")
    }

}