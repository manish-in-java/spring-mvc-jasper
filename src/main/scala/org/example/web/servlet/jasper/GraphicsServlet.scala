package org.example.web.servlet.jasper

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import net.sf.jasperreports.j2ee.servlets.BaseHttpServlet
import net.sf.jasperreports.j2ee.servlets.ImageServlet

/**
 * Generates graphics from a Jasper Report saved in the HTTP Session.
 */
class GraphicsServlet extends ImageServlet {
  /**
   * {@inheritDoc}
   */
  override def service(request: HttpServletRequest, response: HttpServletResponse) {
    try {
      // Allow the parent class to handle the request.
      super.service(request, response)
    } finally {
      // Now that the request has been handled, clean up
      // the HTTP Session to prevent session bloating.
      request.getSession.removeAttribute(BaseHttpServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE)
    }
  }
}
