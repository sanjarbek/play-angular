package controllers

import play.api._
import play.api.libs.json._
import play.api.mvc._
import models.Client

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object Clients extends Controller {

  def list = Action {
    val clients = Client.findAll.map { client => Json.toJson(client)}

    Ok(Json.toJson(clients))
  }

}