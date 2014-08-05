package controllers

import play.api._
import play.api.libs.json._
import play.api.mvc._

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object TestSpa extends Controller {

  def index = Action {
    Ok(views.html.test())
  }

  def home = Action {
    Ok(views.html.home())
  }

  def contact = Action {
    Ok(views.html.contact())
  }

  def about = Action {
    Ok(views.html.about())
  }

}