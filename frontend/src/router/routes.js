import { routes as auth } from '@/modules/auth'
import { routes as commons } from '@/views/commons'
import { routes as home } from '@/views/home'
import { routes as user } from '@/views/user'
import { routes as subdepartment } from '@/views/subdepartment'
import { routes as familyReferences } from '@/views/family_reference'
import { routes as simpleServiceRegistry } from '@/views/simple_service_registry'
import { routes as monitoring } from '@/views/monitoring'
import { routes as dispatchControl } from '@/views/dispatch_control'

export default [
  ...auth,
  ...commons,
  ...home,
  ...user,
  ...subdepartment,
  ...familyReferences,
  ...simpleServiceRegistry,
  ...monitoring,
  ...dispatchControl
]
