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
    nacionalitat = fields.Many2one('res.country', string="Nacionalitat", required = True, help="Escribe tu nacionalitat", store = True)
    ingres = fields.Boolean(required = True, help="Escribe tu ingreso", store = True)
    data_ingres = fields.Date(help="Escribe tu fecha de ingreso", store = True, default=fields.Date.today)
    informacio = fields.Text(help="Escribe tu informacion", store = True)
    asseguranca = fields.Char(help="Escribe tu assegurança", store = True)
    

class especialitat(models.Model):
    
    _name = 'hospitalams_especialitat'
    _description = 'Objecte especialitat'
    
    nom = fields.Char(required = True, help="Escribe el nombre de la especialidad", store = True)
    edifici = fields.Char(required = True, help="Escribe el nombre del edificio", store = True)
    metge_id = fields.One2many('hospitalams_metge', 'dni', string="metge", help="Medico relacionado", store = True)

class metge(models.Model):
    
    _name = 'hospitalams_metge'
    _description = 'Objecte metges'
    
    nom = fields.Char(required = True, help="Escribe tu nombre", store = True)
    cognom = fields.Char(required = True, help="Escribe tu apellido", store = True)
    dni = fields.Char(required = True, help="Escribe tu DNI", store = True)
    genere = fields.Selection([('1', 'Masculino'), ('2', 'Femenino')], help="Escribe tu genero", store = True)
    adreca = fields.Char(help="Escribe tu direccion", store = True)
    anys_experiencia = fields.Integer(help="Escribe los años de experiencia", store = True)
    especialitat_id = fields.Many2one('hospitalams_especialitat', string="especialitat", help="Especialidad", store = True)
    pacient_rel = fields.Many2many('hospitalams_pacient', string="pacient", help="Paciente relacionado", store = True)
    
    edifici_visita = fields.Char(string="Edifici_visita", related="especialitat_id.edifici", store = True)
    
class prova(models.Model):
    
    _name = 'hospitalams_prova'
    _description = 'Objecte prova'
    
    nom = fields.Char(required = True, help="Escribe tu nombre", store = True)
    codi = fields.Selection([('1', 'A'), ('2', 'B'), ('3', 'C') ], required = True, help="Escribe tu apellido", store = True)
    data_prova = fields.Date(help="Escribe tu fecha de prueba", required = True, store = True, default=fields.Date.today)
    resultats = fields.Text(help="Escribe los resultados de la prueba", store = True)
    
    pacient_id = fields.Many2one('hospitalams_pacient', string="pacient", help="Paciente relacionado", store = True)
    prova_id = fields.One2many('hospitalams_prova', 'nom', string="prova", help="Prueba relacionada", store = True)
    doctor_id = fields.Many2many('hospitalams_metge', 'dni', string="doctor", help="Doctor relacionado", store = True)
    
    
    
    