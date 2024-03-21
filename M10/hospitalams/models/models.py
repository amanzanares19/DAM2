# -*- coding: utf-8 -*-

from odoo import models, fields, api


# class hospitalams(models.Model):
#     _name = 'hospitalams.hospitalams'
#     _description = 'hospitalams.hospitalams'

#     name = fields.Char()
#     value = fields.Integer()
#     value2 = fields.Float(compute="_value_pc", store=True)
#     description = fields.Text()
#
#     @api.depends('value')
#     def _value_pc(self):
#         for record in self:
#             record.value2 = float(record.value) / 100

class pacient(models.Model):
    
    _name = 'hospitalams_pacient'
    _description = 'Objecte pacients'
    
    nom = fields.Char(required = True, help="Escribe tu nombre", store = True)
    cognom = fields.Char(required = True, help="Escribe tu apellido", store = True)
    dni = fields.Char(required = True, help="Escribe tu DNI", store = True)
    genere = fields.Selection([('1', 'Masculino'), ('2', 'Femenino')], help="Escribe tu genero", store = True)
    data_naixement = fields.Date(required = True,help="Escribe tu fecha de nacimiento", store = True)
    #nacionalitat = fields.Many2one('res.country', string="País", required = True, help="Escribe tu nacionalitat", store = True)
    ingres = fields.Boolean(required = True, help="Escribe tu ingreso", store = True)
    data_ingres = fields.Date(help="Escribe tu fecha de ingreso", store = True, default=fields.Date.today)
    informacio = fields.Text(help="Escribe tu informacion", store = True)
    asseguranca = fields.Char(help="Escribe tu assegurança", store = True)