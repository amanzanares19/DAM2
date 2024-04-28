# -*- coding: utf-8 -*-
# from odoo import http


# class Hospitalams(http.Controller):
#     @http.route('/hospitalams/hospitalams', auth='public')
#     def index(self, **kw):
#         return "Hello, world"

#     @http.route('/hospitalams/hospitalams/objects', auth='public')
#     def list(self, **kw):
#         return http.request.render('hospitalams.listing', {
#             'root': '/hospitalams/hospitalams',
#             'objects': http.request.env['hospitalams.hospitalams'].search([]),
#         })

#     @http.route('/hospitalams/hospitalams/objects/<model("hospitalams.hospitalams"):obj>', auth='public')
#     def object(self, obj, **kw):
#         return http.request.render('hospitalams.object', {
#             'object': obj
#         })
