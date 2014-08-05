package controllers

import play.api._
import play.api.libs.json._
import play.api.mvc._
import models.Client

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object Clients extends Controller {

  def index = Action {
    Ok(views.html.spa())
  }
  
  def create = Action {
    Ok(views.html.client.create())
  }

  def list = Action {
    Ok(views.html.client.list())
  }

  def jsonList(page: Int, pageSize: Int) = Action {
    val clients = Client.findAll.map { client => Json.toJson(client)}

    Ok(Json.toJson(clients))
  }

}