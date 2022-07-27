export const isValidDate = dateString => {
  const regEx = /^\d{4}-\d{2}-\d{2}$/
  if (!dateString.match(regEx)) return false

  const d = new Date(dateString)

  const dNum = d.getTime()
  if (!dNum && dNum !== 0) return false

  return d.toISOString().slice(0, 10) === dateString
}

export const isValidDateAndYear = dateString => {
  const regEx = /^\d{4}-\d{2}-\d{2}$/
  if (!dateString.match(regEx)) return false

  const d = new Date(dateString)
  const dYear = d.getFullYear()
  const maxYear = new Date().getFullYear()
  if (dYear < 1900 || dYear > maxYear) return false

  const dNum = d.getTime()
  if (!dNum && dNum !== 0) return false

  return d.toISOString().slice(0, 10) === dateString
}
