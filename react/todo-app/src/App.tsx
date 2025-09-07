import { useState } from "react"
import { motion, AnimatePresence } from "framer-motion"
import { Plus, Trash2, Moon, Sun } from "lucide-react"

interface Task {
  id: number
  text: string
}

export default function App() {
  const [tasks, setTasks] = useState<Task[]>([])
  const [input, setInput] = useState("")
  const [darkMode, setDarkMode] = useState(false)

  const addTask = () => {
    if (!input.trim()) return
    setTasks([...tasks, { id: Date.now(), text: input }])
    setInput("")
  }

  const removeTask = (id: number) => {
    setTasks(tasks.filter((task) => task.id !== id))
  }

  return (
    <div
      className={`min-h-screen flex items-center justify-center px-4 transition-colors duration-500 ${
        darkMode
          ? "bg-gradient-to-br from-gray-900 via-gray-800 to-gray-900"
          : "bg-gradient-to-br from-blue-100 via-indigo-100 to-purple-100"
      }`}
    >
      <div
        className={`w-full max-w-md backdrop-blur-xl bg-white/30 dark:bg-gray-800/40 shadow-2xl rounded-2xl p-6 transition`}
      >
        {/* Header */}
        <div className="flex justify-between items-center mb-6">
          <h1 className="text-2xl font-bold text-white dark:text-gray-100">
            Task Manager
          </h1>
          <button
            onClick={() => setDarkMode(!darkMode)}
            className="p-2 rounded-full hover:bg-white/20 dark:hover:bg-gray-700 transition"
          >
            {darkMode ? (
              <Sun className="w-5 h-5 text-yellow-400" />
            ) : (
              <Moon className="w-5 h-5 text-gray-700" />
            )}
          </button>
        </div>

        {/* Input */}
        <div className="flex space-x-2 mb-6">
          <input
            type="text"
            placeholder="Enter a task..."
            value={input}
            onChange={(e) => setInput(e.target.value)}
            className="flex-1 px-4 py-2 rounded-xl bg-white/60 dark:bg-gray-700/60 border border-gray-300 dark:border-gray-600 text-gray-800 dark:text-gray-100 focus:outline-none focus:ring-2 focus:ring-indigo-400"
          />
          <button
            onClick={addTask}
            className="px-4 py-2 bg-indigo-500 text-white rounded-xl hover:bg-indigo-600 active:scale-95 transition flex items-center gap-1"
          >
            <Plus className="w-4 h-4" /> Add
          </button>
        </div>

        {/* Tasks */}
        <ul className="space-y-3">
          <AnimatePresence>
            {tasks.map((task) => (
              <motion.li
                key={task.id}
                initial={{ opacity: 0, y: 20 }}
                animate={{ opacity: 1, y: 0 }}
                exit={{ opacity: 0, x: -50 }}
                transition={{ duration: 0.3 }}
                className="flex justify-between items-center bg-white/70 dark:bg-gray-700/70 px-4 py-2 rounded-xl shadow hover:shadow-md transition"
              >
                <span className="text-gray-800 dark:text-gray-100">
                  {task.text}
                </span>
                <button
                  onClick={() => removeTask(task.id)}
                  className="text-red-500 hover:text-red-700 transition"
                >
                  <Trash2 className="w-5 h-5" />
                </button>
              </motion.li>
            ))}
          </AnimatePresence>
        </ul>

        {/* Footer */}
        <div className="mt-6 text-center text-sm text-white ">
          {tasks.length === 0
            ? "No tasks yet. Add something ✍️"
            : `${tasks.length} task(s) pending`}
        </div>
      </div>
    </div>
  )
}
